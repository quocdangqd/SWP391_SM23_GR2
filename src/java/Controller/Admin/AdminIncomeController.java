/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import Dal.AccountDao;
import Dal.OrderDAO;
import Dal.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author trand
 */
public class AdminIncomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        ProductDAO dao = new ProductDAO();
        OrderDAO od = new OrderDAO();
        AccountDao ad = new AccountDao();

        int count = dao.CountProduct();
        int count1 = od.CountOrder();
        int count2 = dao.CountProductOut();
        int count3 = od.CountOrderCancelled();
        int count4 = ad.AccountBanned();
        int total = dao.totalIncome();
        List listpro = dao.BestSellerProducts();
        List listun = dao.limitProducts();
        

        request.setAttribute("product", count);
        request.setAttribute("order", count1);
        request.setAttribute("het", count2);
        request.setAttribute("huy", count3);
        request.setAttribute("chan", count4);
        request.setAttribute("tong", total);
        request.setAttribute("listP", listpro);
        request.setAttribute("listun", listun);

        request.getRequestDispatcher("/admin/incomemanager.jsp").forward(request, response);
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
