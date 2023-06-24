/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import Dal.ManagerDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;

public class ManagerAddProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        if (session.getAttribute("account") == null) {
//            req.getRequestDispatcher("home.jsp").forward(req, resp);
//        }
//        req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);
resp.setContentType("text/html;charset=UTF-8");

        ManagerDAO dao = new ManagerDAO();
        String Cid = req.getParameter("cid");
        String Name = req.getParameter("name");
        String Desciption = req.getParameter("desciption");
        String Image = req.getParameter("image");
        String Price = req.getParameter("price");
        String Quantity = req.getParameter("quantity");
        String Status = req.getParameter("status");

        req.setAttribute("name", Name);
        req.setAttribute("price", Price);
        req.setAttribute("image", Image);
        req.setAttribute("cid", Cid);
        req.setAttribute("desciption", Desciption);
        req.setAttribute("quantity", Quantity);
        req.setAttribute("status", Status);
        dao.addNewProduct(Cid, Name, Desciption, Image, Price, Quantity, Status);
        req.setAttribute("successText", "Add Successful!!!");
        req.getRequestDispatcher("addproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
    }

}
