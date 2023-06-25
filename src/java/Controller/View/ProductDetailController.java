/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.View;

import Dal.CartDAO;
import Dal.FeedbackDAO;
import Dal.ProductDAO;
import Model.Cart;
import Model.Feedback;
import Model.Products;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author PC
 */
public class ProductDetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            ProductDAO pdao = new ProductDAO();
            if (request.getParameter("addToCart") != null) {
                if (user == null) {
                    response.sendRedirect(request.getContextPath() + "/auth/login");
                    return;
                }
//                out.print(request.getParameter("quantity"));
                Products productDetail = (Products) session.getAttribute("productDetail");
                String quantity = request.getParameter("quantity");
                Cart cart = new Cart(productDetail.getSalePrice(), quantity, productDetail.getProductID(), user.getUserID(), "1");//1 default 
                CartDAO cartDAO = new CartDAO();
                boolean checkAddToCart = cartDAO.AddOrUpdateCart(cart);
                request.setAttribute("checkAddToCart", checkAddToCart);
            } else if (request.getParameter("submitComment") != null) {
                out.print("submitComment");
            } else {
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                decimalFormat.applyPattern("#,###");
                String ProductID = request.getParameter("ProductID");
                Products productDetail = pdao.getProductByID(ProductID);
                String salePrice = decimalFormat.format(Float.parseFloat(productDetail.getSalePrice()));
                salePrice = salePrice.replaceAll(",", ".");
                FeedbackDAO feedbackDAO = new FeedbackDAO();
                ArrayList<Feedback> feedbackList = feedbackDAO.getFeedbackListByProductId(ProductID);
                request.setAttribute("feedbackList", feedbackList);
                request.setAttribute("salePrice", salePrice);
                session.setAttribute("productDetail", productDetail);
//                out.print(" " + productDetail.getQuantity());
            }
            request.getRequestDispatcher("productDetail.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
