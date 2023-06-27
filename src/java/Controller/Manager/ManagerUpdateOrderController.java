/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import Dal.ManagerDAO;
import Model.Order;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ManagerUpdateOrderController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ManagerDAO dao = new ManagerDAO();
        String id = req.getParameter("id");
        dao.LoadOneOrder(id);
        Order order = dao.getOneOrder();
        req.setAttribute("o", order);
        req.getRequestDispatcher("editorder.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ManagerDAO dao = new ManagerDAO();
        String orderID = req.getParameter("id");
        String order_userID = req.getParameter("user");
        String order_salecodeID = req.getParameter("saler");
        String order_shippingID = req.getParameter("order");
        String date = req.getParameter("date");
        String status = req.getParameter("status");
        dao.updateOrder(orderID, order_shippingID, date, order_userID, date, order_salecodeID, status);
        
        req.setAttribute("id", orderID);
        req.setAttribute("user", order_userID);
        req.setAttribute("saler", order_salecodeID);
        req.setAttribute("order", order_shippingID);
        req.setAttribute("date", date);
        req.setAttribute("status", status);
        req.setAttribute("successText", "Add Successful!!!");
        req.getRequestDispatcher("editorder.jsp").forward(req, resp);
    }
    
}
