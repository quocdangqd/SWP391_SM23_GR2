/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import Dal.ManagerDAO;
import Model.DetailOrder;
import Model.Order;
import Model.Orderdetail;
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
        DetailOrder od = dao.getAllDetailOrderByOrderID(id);
        String totalPrice = String.valueOf(Float.parseFloat(od.getPrice()) * Integer.parseInt(od.getQuantity()));
        req.setAttribute("totalPrice", totalPrice);
        req.setAttribute("o", od);
        req.getRequestDispatcher("orderdetail.jsp").forward(req, resp);
    } 

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        
    }

}
