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
        Products p = dao.getProductsByID(id);

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

        p.setProductID(id);
        p.setProduct_categoryID(Cid);
        p.setName(Name);
        p.setDesciption(Desciption);
        p.setPicture(Image1);
        p.setPicture2(Image2);
        p.setPicture3(Image3);
        p.setQuantity(Quantity);
        p.setPrice(Price);
        p.setStatus(Status);
        p.setDate(date);
        dao.updateProduct(p);
        
        
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
        
        req.setAttribute("o", p);
        req.setAttribute("earphone", e);

        req.setAttribute("successText", "Update Successful!!!");
        req.getRequestDispatcher("editproduct.jsp").forward(req, resp);

    }
}
