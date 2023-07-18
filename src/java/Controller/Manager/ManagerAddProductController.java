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

public class ManagerAddProductController extends HttpServlet {

    ManagerDAO dao = new ManagerDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CategoriesDAO ca = new CategoriesDAO();
        req.setAttribute("categoriesList", ca.GetCategoriesList());
        req.getRequestDispatcher("addproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CategoriesDAO ca = new CategoriesDAO();
        req.setAttribute("categoriesList", ca.GetCategoriesList());
        String Cid = req.getParameter("category");
        String Name = req.getParameter("name");
        String Desciption = req.getParameter("mota");
        String Image1 = req.getParameter("image");
        String Image2 = req.getParameter("image2");
        String Image3 = req.getParameter("image3");
        String Price = req.getParameter("price");
        String Quantity = req.getParameter("quantity");
        String Status = req.getParameter("status");
        String date = req.getParameter("date");

        req.setAttribute("name", Name);
        req.setAttribute("price", Price);
        req.setAttribute("image", Image1);
        req.setAttribute("image2", Image2);
        req.setAttribute("image3", Image3);
        req.setAttribute("category", Cid);
        req.setAttribute("mota", Desciption);
        req.setAttribute("quantity", Quantity);
        req.setAttribute("status", Status);

        if(Float.parseFloat(Price) > 200000 && Integer.parseInt(Quantity) > 1
                && (Image1.endsWith(".png") || Image1.endsWith(".jpg"))
                && (Image2.endsWith(".png") || Image2.endsWith(".jpg"))
                && (Image3.endsWith(".png") || Image3.endsWith(".jpg"))) {
            dao.addNewProduct(Cid, Name, Desciption, Image1, Image2, Image3,Price, Quantity, Status, date);

            req.setAttribute("successText", "Add Successful!!!");
        }else {
            if (Float.parseFloat(Price) < 200000) {
                req.setAttribute("PriceErr", "Price must Enter at least 200,000");
            }
            if (Integer.parseInt(Quantity) < 1) {
                req.setAttribute("QuantityErr", "Quantiy must enter at leat 1");
            }
            if (!(Image1.endsWith(".png") || Image1.endsWith(".jpg"))) {
                req.setAttribute("Image1Err", "Must enter file with .png or .jpg");
            }
            if (!(Image2.endsWith(".png") || Image2.endsWith(".jpg"))) {
                req.setAttribute("Image2Err", "Must enter file with .png or .jpg");
            }
            if (!(Image3.endsWith(".png") || Image3.endsWith(".jpg"))) {
                req.setAttribute("Image3Err", "Must enter file with .png or .jpg");
            }

        } 
        req.getRequestDispatcher("addproduct.jsp").forward(req, resp);

    }
}
