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
                int headPhonepageIndex = 1;
                if (request.getParameter("headPhonepageIndex") != null) {// click phan trang
                    headPhonepageIndex = Integer.parseInt(request.getParameter("headPhonepageIndex"));
                } else {
                    ArrayList<Products> headPhoneData;
                    String searchInput = "";
                    String headPhonesortOrder = null;
                    String searchSubmit = request.getParameter("searchSubmit");
                    if (searchSubmit != null) {// click search
                        searchInput = request.getParameter("searchInput");
                        headPhonesortOrder = (String) session.getAttribute("headPhonesortOrder");
                        headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, headPhonesortOrder);
                    } else {//  click sortOrder //searchSubmit == null
                        headPhonesortOrder = request.getParameter("headPhonesortOrder");
                        if (headPhonesortOrder != null) {
                            searchInput = (String) session.getAttribute("searchInput");
                            headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, headPhonesortOrder);
                        } else {// first time called sortorder= rate(default)
                            headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, "rate");
                        }
                    }
                    session.setAttribute("headPhonesortOrder", headPhonesortOrder);
                    session.setAttribute("searchInput", searchInput);
                    session.setAttribute("headPhoneData", headPhoneData);
                    int headPhoneamountElementInPage;
                    if (request.getParameter("headPhoneamountElementInPage") != null) {
                        headPhoneamountElementInPage = Integer.parseInt(request.getParameter("headPhoneamountElementInPage"));
                    }
                    else {
                        if (session.getAttribute("headPhoneamountElementInPage") == null) {
                            headPhoneamountElementInPage = 6;
                        } else {
                            headPhoneamountElementInPage = (int) session.getAttribute("headPhoneamountElementInPage");
                        }
                    }
                    session.setAttribute("headPhoneamountElementInPage", headPhoneamountElementInPage);
                    int headPhonepageAmount = headPhoneData.size() / headPhoneamountElementInPage;
                    if (headPhoneData.size() % headPhoneamountElementInPage != 0) {
                        ++headPhonepageAmount;
                    }
                    session.setAttribute("headPhonepageAmount", headPhonepageAmount);
                    
                }
                request.setAttribute("headPhonepageIndex", headPhonepageIndex);
                request.setAttribute("active", "active");
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
