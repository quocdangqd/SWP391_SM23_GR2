/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import Dal.CategoriesDAO;
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
        CategoriesDAO cdao = new CategoriesDAO();
        dao.getAllProduct();
        req.setAttribute("dao", dao);
        req.setAttribute("listP", dao.getProduct());
        req.setAttribute("listC", cdao.GetCategoriesList());
        req.getRequestDispatcher("productmanager.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
    }

}
