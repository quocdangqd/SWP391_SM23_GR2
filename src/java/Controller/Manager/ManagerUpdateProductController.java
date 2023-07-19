/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import Dal.CategoriesDAO;
import Dal.ManagerDAO;
import Dal.ProductDAO;
import Model.Earphone;
import Model.Products;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ManagerUpdateProductController extends HttpServlet {

    ManagerDAO dao = new ManagerDAO();
    ProductDAO daop = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        Products p = dao.getProductsByID(id);
        if ("1".equals(p.getCategories().getCategoryID())) {
            req.setAttribute("earphone",
                    daop.getEarphoneByProductID(p.getProductID()));
        }
        CategoriesDAO ca = new CategoriesDAO();
        req.setAttribute("categoriesList", ca.GetCategoriesList());
        req.setAttribute("o", p);
        req.getRequestDispatcher("editproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("pid");
        CategoriesDAO ca = new CategoriesDAO();
        req.setAttribute("categoriesList", ca.GetCategoriesList());

        String Cid = req.getParameter("category");
        String Name = req.getParameter("name");
        String Desciption = req.getParameter("description");
        String Image1 = req.getParameter("image");
        String Image2 = req.getParameter("image2");
        String Image3 = req.getParameter("image3");
        String Price = req.getParameter("price").replace(",", "");
        String Quantity = req.getParameter("quantity");
        String Status = req.getParameter("status");
        String date = req.getParameter("date");
//        dao.updateProduct(Cid, Name, Desciption, Image, Image2, Image3, Quantity, Status, Price, date, id);
        Products p = dao.getProductsByID(id);
        req.setAttribute("o", p);

        Earphone e = new Earphone();
        String type = req.getParameter("type");
        String frequency = req.getParameter("frequency");
        String sensitive = req.getParameter("sensitive");
        String impedance = req.getParameter("impedance");
        String meterial = req.getParameter("meterial");
        String size = req.getParameter("size");
        String battery = req.getParameter("battery");
        String connection_distance = req.getParameter("connection_distance");
        String wire_length = req.getParameter("wire_length");
        if ("1".equals(Cid)) {
            e.setType(type);
            e.setFrequency(frequency);
            e.setSensitive(sensitive);
            e.setImpedance(impedance);
            e.setMeterial(meterial);
            e.setSize(size);
            e.setBattery(battery);
            e.setConnection_distance(connection_distance);
            e.setWire_length(wire_length);
            e.setEarphone_ProductID(id);
            daop.updateEarphone(e);
        }
        if ("1".equals(p.getCategories().getCategoryID())) {
            req.setAttribute("earphone",
                    daop.getEarphoneByProductID(p.getProductID()));
        }
        req.setAttribute("name", Name);
        req.setAttribute("price", Price.replace(",", ""));
        req.setAttribute("image", Image1);
        req.setAttribute("image2", Image2);
        req.setAttribute("image3", Image3);
        req.setAttribute("category", Cid);
        req.setAttribute("mota", Desciption);
        req.setAttribute("quantity", Quantity);
        req.setAttribute("status", Status);
        req.setAttribute("date", date);
        req.setAttribute("type", type);
        req.setAttribute("frequency", frequency);
        req.setAttribute("sensitive", sensitive);
        req.setAttribute("impedance", impedance);
        req.setAttribute("meterial", meterial);
        req.setAttribute("size", size);
        req.setAttribute("battery", battery);
        req.setAttribute("connection_distance", connection_distance);
        req.setAttribute("wire_length", wire_length);

        if (Float.parseFloat(Price) > 200000 && Integer.parseInt(Quantity) > 1
                && (Image1.endsWith(".png") || Image1.endsWith(".jpg"))
                && (Image2.endsWith(".png") || Image2.endsWith(".jpg"))
                && (Image3.endsWith(".png") || Image3.endsWith(".jpg"))) {
            dao.updateProduct(Cid, Name, Desciption, Image1, Image2, Image3, Price, Quantity, Status, date, id);

            req.setAttribute("successText", "Add Successful!!!");
        } else {
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
        req.setAttribute("successText", "Update Successful!!!");
        req.getRequestDispatcher("editproduct.jsp").forward(req, resp);

    }
}
