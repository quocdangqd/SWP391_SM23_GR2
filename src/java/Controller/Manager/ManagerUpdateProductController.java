/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import Dal.ManagerDAO;
import Model.Products;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ManagerUpdateProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ManagerDAO dao = new ManagerDAO();
        String Pid = req.getParameter("pid");
        String Cid = req.getParameter("cid");
        String Name = req.getParameter("name");
        String Desciption = req.getParameter("desciption");
        String Image = req.getParameter("image");
        String Price = req.getParameter("price");
        String Quantity = req.getParameter("quantity");
        String Status = req.getParameter("status");

        dao.updateProduct(Cid, Cid, Name, Desciption, Image, Quantity, Status, Price);
        req.setAttribute("name", Name);
        req.setAttribute("price", Price);
        req.setAttribute("image", Image);
        req.setAttribute("cid", Cid);
        req.setAttribute("pid", Pid);
        req.setAttribute("desciption", Desciption);
        req.setAttribute("quantity", Quantity);
        req.setAttribute("status", Status);
        req.setAttribute("successText", "Add Successful!!!");
        req.getRequestDispatcher("productmanager.jsp").forward(req, resp);

    }

}
