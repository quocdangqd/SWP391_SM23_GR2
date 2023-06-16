package Controller.View;

import Dal.ProductDAO;
import Model.Earphone;
import Model.Products;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author DucPhaoLo
 */
public class ProductListController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String tab = "headphone";
//            String tab = request.getParameter("tab");
            HttpSession session = request.getSession();
            ProductDAO pdao = new ProductDAO();
            if (tab.equals("allProduct")) {
                session.setAttribute("tab", "allProduct");
//                ArrayList<Products> headPhoneData = pdao.getProductListByCategoryIDAndSort("1", "rate");
//                ArrayList<Products> headPhoneData = pdao.getProductListByCategoryIDAndSort("1", "rate");
//                ArrayList<Products> headPhoneData = pdao.getProductListByCategoryIDAndSort("1", "rate");
//                request.setAttribute("headPhoneData", headPhoneData);
            } else if (tab.equals("headphone")) {
                session.setAttribute("tab", "headphone");
                int pageIndex = 0;
                if (request.getParameter("pageIndex") != null) {// click phan trang
                    pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
                } else {
                    ArrayList<Products> headPhoneData;
                    String searchInput = "";
                    String sortOrder = null;
                    String searchSubmit = request.getParameter("searchSubmit");
//                    String searchSubmit = "a";
                    if (searchSubmit != null) {// click search
                        searchInput = request.getParameter("searchInput");
                        headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, "rate");
                    } else {//  click sortOrder //searchSubmit == null
//                        sortOrder = request.getParameter("sortOrder");
                        sortOrder = request.getParameter("sortOrder");
                        if (sortOrder != null) {
                            searchInput = (String) session.getAttribute("searchInput");
                            headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, sortOrder);
                        } else {
                            // first time called sortorder= rate(default)
                            headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", "", "rate");
                        }
                    }
                    session.setAttribute("sortOrder", sortOrder);
                    session.setAttribute("searchInput", searchInput);
                    session.setAttribute("headPhoneData", headPhoneData);
                    int amountElementInPage = 0;
                    if (request.getParameter("amountElementInPage") != null) {
                        amountElementInPage = Integer.parseInt(request.getParameter("amountElementInPage"));
                    } else {
                        if (session.getAttribute("amountElementInPage") == null) {
                            amountElementInPage = 5;
                        } else {
                            out.print("size = " + headPhoneData.size());
                            amountElementInPage = (int) session.getAttribute("amountElementInPage");
                        }
                    }
                    session.setAttribute("amountElementInPage", amountElementInPage);
                    int pageAmount = headPhoneData.size() / amountElementInPage;
                    if (headPhoneData.size() % amountElementInPage != 0) {
                        ++pageAmount;
                    }
                    session.setAttribute("pageAmount", pageAmount);
                    if (pageAmount > 0) {
                        pageIndex = 1;
                    }
                    out.print("pageIndex = " + pageIndex + "<br>");
                    out.print("pageAmount = " + pageAmount + "<br>");
//                    out.print("pageIndex = "+pageIndex); 
                }
                request.setAttribute("pageIndex", pageIndex);
            } else if (tab.equals("mouse")) {
                session.setAttribute("tab", "mouse");
            } else if (tab.equals("keyboard")) {
                session.setAttribute("tab", "keyboard");
            }

            request.getRequestDispatcher("/view/listProduct.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            String tab = request.getParameter("tab");
//            out.print("tab: "+tab); 
//            if(tab.equals("allProduct"))
//            {
//                out.print("Show all product");  
//            }
//            else if(tab.equals("headphone"))
//            {
//                out.print("Show all headphone");  
//            }
//            else if(tab.equals("mouse"))
//            {
//                out.print("Show all mouse");  
//            }
//            else if(tab.equals("keyboard"))
//            {
//                out.print("Show all keyboard");  
//            }
//        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
