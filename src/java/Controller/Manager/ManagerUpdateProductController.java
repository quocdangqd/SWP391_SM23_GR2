/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import Dal.CategoriesDAO;
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
        ManagerDAO dao = new ManagerDAO();
        String id = req.getParameter("id");
        Products p = dao.getProductsByID(id);
        CategoriesDAO ca = new CategoriesDAO();
        req.setAttribute("categoriesList", ca.GetCategoriesList());
        req.setAttribute("o", p);
        req.getRequestDispatcher("editproduct.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ManagerDAO dao = new ManagerDAO();
        String id = req.getParameter("pid");
        Products p = dao.getProductsByID(id);
        CategoriesDAO ca = new CategoriesDAO();
        req.setAttribute("categoriesList", ca.GetCategoriesList());
        req.setAttribute("o", p);
        
        String Cid = req.getParameter("category");
        String Name = req.getParameter("name");
        String Desciption = req.getParameter("desciption");
        String Image = req.getParameter("image");
        String Image2 = req.getParameter("image2");
        String Image3 = req.getParameter("image3");
        String Price = req.getParameter("price");
        String Quantity = req.getParameter("quantity");
        String Status = req.getParameter("status");
        
        System.out.println("Cid "+Cid);
        System.out.println("Name: "+ Name);
        System.out.println("Description: "+Desciption);
        System.out.println("Image: "+Image+Image2+Image3);
        System.out.println("Price: "+ Price);
        System.out.println("Quantity: "+ Quantity);
        System.out.println("Status: "+Status);
        dao.updateProduct(Cid, Name, Desciption, Image, Image2, Image3, Quantity, Status, Price, id);
        
        req.setAttribute("pid", id);
        req.setAttribute("name", Name);
        req.setAttribute("price", Price);
        req.setAttribute("image", Image);
        req.setAttribute("image2", Image2);
        req.setAttribute("image3", Image3);
        req.setAttribute("category", Cid);
        req.setAttribute("description", Desciption);
        req.setAttribute("quantity", Quantity);
        req.setAttribute("status", Status);
//        p.setProductID(id);
//        p.setProduct_categoryID(Cid);
//        p.setName(Name);
//        p.setDesciption(Desciption);
//        p.setPicture(Image);
//        p.setPicture2(Image2);
//        p.setPicture3(Image3);
//        p.setQuantity(Quantity);
//        p.setPrice(Price);
//        p.setStatus(Status);
//        dao.updateProduct(p);
//        resp.sendRedirect("ManagerProductController");
        req.getRequestDispatcher("editproduct.jsp").forward(req, resp);

    }

}
