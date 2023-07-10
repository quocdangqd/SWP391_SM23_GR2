/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import Dal.ManagerDAO;
import Model.DetailOrder;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ManagerOrderDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ManagerDAO dao = new ManagerDAO();
        String id = req.getParameter("id");
        
        dao.getListOrder();
        req.setAttribute("od", dao.getAllDetailOrderByOrderID(id));
        double total = 0;
        for (DetailOrder orderDetail : dao.getAllDetailOrderByOrderID(id)) {
            total += (Integer.parseInt(orderDetail.getQuantity()) * Float.parseFloat(orderDetail.getPrice_product()));
        }
        double tax = total * 0.1;
        double grandTotal = total + tax;
        req.setAttribute("total", total);
        req.setAttribute("tax", tax);
        req.setAttribute("grandTotal", grandTotal);
        req.getRequestDispatcher("orderdetail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}
