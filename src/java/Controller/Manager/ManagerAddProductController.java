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

    ManagerDAO dao = new ManagerDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        if (session.getAttribute("account") == null) {
//            req.getRequestDispatcher("home.jsp").forward(req, resp);
//        }
//        req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);       

        req.getRequestDispatcher("addproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String Cid = req.getParameter("cid");
        String Name = req.getParameter("name");
        String Desciption = req.getParameter("mota");
        String Image1 = req.getParameter("ImageUpload");
        String Image2 = req.getParameter("image2");
        String Image3 = req.getParameter("image3");
        String Price = req.getParameter("price");
        String Quantity = req.getParameter("quantity");
        String Status = req.getParameter("status");
        
        System.out.println("Cid: " + Cid);
        System.out.println("Name: "+Name);
        System.out.println("Description: "+Desciption);
        System.out.println("Image1: "+Image1);
        System.out.println("Price: "+ Price);
        System.out.println("Quantity: "+Quantity);
        System.out.println("Status :"+Status);
        
        req.setAttribute("name", Name);
        req.setAttribute("price", Price);
        req.setAttribute("ImageUpload", Image1);
        req.setAttribute("image2", Image2);
        req.setAttribute("image3", Image3);
        req.setAttribute("cid", Cid);
        req.setAttribute("mota", Desciption);
        req.setAttribute("quantity", Quantity);
        req.setAttribute("status", Status);
//
//        if (Name.isEmpty()) {
//            req.setAttribute("wrongText", "Name is empty!!!");
//            req.getRequestDispatcher("addproduct.jsp").forward(req, resp);
//        }
//        if (Price.isEmpty()) {
//            req.setAttribute("wrongText", "Price is empty!!!");
//            req.getRequestDispatcher("addproduct.jsp").forward(req, resp);
//        }
//        if (Image1.isEmpty()) {
//            req.setAttribute("wrongText", "Image is empty!!!");
//            req.getRequestDispatcher("addproduct.jsp").forward(req, resp);
//        }
//        if (Cid.isEmpty()) {
//            req.setAttribute("wrongText", "Cid is empty!!!");
//            req.getRequestDispatcher("addproduct.jsp").forward(req, resp);
//        }

            dao.addNewProduct(Cid, Name, Desciption, Image1, Image2, Image3, Quantity, Status, Price);
            req.setAttribute("successText", "Add Successful!!!");
        req.getRequestDispatcher("addproduct.jsp").forward(req, resp);
    }

}
