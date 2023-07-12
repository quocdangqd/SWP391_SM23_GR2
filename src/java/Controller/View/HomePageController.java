package Controller.View;

import Dal.ProductDAO;
import Model.Categories;
import Model.Products;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author DucPhaoLo
 */
public class HomePageController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String tab = request.getParameter("tab");
            ProductDAO productDAO = new ProductDAO();
            HttpSession session = request.getSession();
            if (tab == null || tab.equals("homepage")) {
                ArrayList<Products> bestProductList = new ArrayList<>();
                bestProductList = productDAO.BestSellerProducts();
                session.setAttribute("bestProductList", bestProductList);
//                out.print(bestProductList.size()+"<br>"); 
                String type = request.getParameter("type");
<<<<<<< HEAD
                ArrayList<Products> typeProductList =null;
=======
                ArrayList<Products> typeProductList = null;
>>>>>>> main
                if (type != null) {
                    typeProductList = productDAO.getProductListByType(type);
                } else if (session.getAttribute("type") != null) {
                    type = (String) session.getAttribute("type");
<<<<<<< HEAD
=======
                    typeProductList = productDAO.getProductListByType(type);
>>>>>>> main
                } else {
                    type = "Wired";
                    typeProductList = productDAO.getProductListByType(type);
                }
                session.setAttribute("typeProductList", typeProductList);
                session.setAttribute("type", type);
//                out.print(typeProductList.size()); 
            } else if (tab.equals("logOut")) {
                session.removeAttribute("role");
            }
<<<<<<< HEAD
            session.setAttribute("tab", "allProduct");
=======
            
            session.setAttribute("tab", "allProduct");
            
>>>>>>> main
            request.getRequestDispatcher("/view/homepage.jsp").forward(request, response);
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
