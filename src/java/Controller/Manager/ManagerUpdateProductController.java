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
        CategoriesDAO ca = new CategoriesDAO();
        req.setAttribute("categoriesList", ca.GetCategoriesList());

        String Cid = req.getParameter("category");
        String Name = req.getParameter("name");
        String Desciption = req.getParameter("description");
        String Image = req.getParameter("image");
        String Image2 = req.getParameter("image2");
        String Image3 = req.getParameter("image3");
        String Price = req.getParameter("price");
        String Quantity = req.getParameter("quantity");
        String Status = req.getParameter("status");
        String date = req.getParameter("date");
        dao.updateProduct(Cid, Name, Desciption, Image, Image2, Image3, Quantity, Status, Price, date, id);
        Products p = dao.getProductsByID(id);
        req.setAttribute("o", p);

        if (Float.parseFloat(Price) > 200000 && Integer.parseInt(Quantity) > 1
                && (Image.endsWith(".png") || Image.endsWith(".jpg"))
                && (Image2.endsWith(".png") || Image2.endsWith(".jpg"))
                && (Image3.endsWith(".png") || Image3.endsWith(".jpg"))) {
            dao.updateProduct(Cid, Name, Desciption, Image, Image2, Image3, Quantity, Status, Price, date, id);

            req.setAttribute("successText", "Update Successful!!!");
        } else {
            if (Float.parseFloat(Price) < 200000) {
                req.setAttribute("PriceErr", "Price must Enter at least 200,000");
            }
            if (Integer.parseInt(Quantity) < 1) {
                req.setAttribute("QuantityErr", "Quantiy must enter at leat 1");
            }
            if (!(Image.endsWith(".png") || Image.endsWith(".jpg"))) {
                req.setAttribute("Image1Err", "Must enter file with .png or .jpg");
            }
            if (!(Image2.endsWith(".png") || Image2.endsWith(".jpg"))) {
                req.setAttribute("Image2Err", "Must enter file with .png or .jpg");
            }
            if (!(Image3.endsWith(".png") || Image3.endsWith(".jpg"))) {
                req.setAttribute("Image3Err", "Must enter file with .png or .jpg");
            }

        }
        req.setAttribute("successText", "Update Successful!!!");

        req.getRequestDispatcher("editproduct.jsp").forward(req, resp);

    }

}
