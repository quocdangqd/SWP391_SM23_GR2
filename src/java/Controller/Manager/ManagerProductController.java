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

public class ManagerProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//        HttpSession session = req.getSession();
//        if (session.getAttribute("") == null) {
//            req.getRequestDispatcher("login.jsp").forward(req, resp);
//        }
        ManagerDAO dao = new ManagerDAO();
        dao.getAllProduct();
        req.setAttribute("dao", dao);
        req.setAttribute("listP", dao.getProduct());

        req.getRequestDispatcher("productmanager.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {

        if(req.getParameter("Update")!=null){
            out.print("hi");
            return;
        }
        ManagerDAO dao = new ManagerDAO();
        String Pid = req.getParameter("pid");
        String Cid = req.getParameter("cid");
        String Name = req.getParameter("name");
        String Desciption = req.getParameter("desciption");
        String Image = req.getParameter("image");
        String Price = req.getParameter("price");
        String Quantity = req.getParameter("quantity");
        String Status = req.getParameter("status");

        dao.updateProduct(Pid, Cid, Name, Desciption, Image, Quantity, Status, Price);
        req.setAttribute("name", Name);
        req.setAttribute("price", Price);
        req.setAttribute("image", Image);
        req.setAttribute("cid", Cid);
        req.setAttribute("pid", Pid);
        req.setAttribute("desciption", Desciption);
        req.setAttribute("quantity", Quantity);
        req.setAttribute("status", Status);
        req.setAttribute("successText", "Update Successful!!!");
        req.getRequestDispatcher("productmanager.jsp").forward(req, resp);
    }
    }

}
