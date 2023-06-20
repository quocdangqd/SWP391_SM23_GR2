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
            String tab = request.getParameter("tab");
            if(tab==null)
                tab = "allProduct";
            HttpSession session = request.getSession();
            ProductDAO pdao = new ProductDAO();
            if (tab.equals("headphone") || tab.equals("allProduct")) {
                if (tab.equals("headphone")) {
//                    session.setAttribute("tab", "headphone");
                    request.setAttribute("tab", "headphone");
                } else {
//                    session.setAttribute("tab", "allProduct");
                    request.setAttribute("tab", "allProduct");
                }
                int headPhonepageIndex = 1;
                if (request.getParameter("headPhonepageIndex") != null
                        || request.getParameter("mousesortOrder") != null
                        || request.getParameter("mousepageIndex") != null
                        || request.getParameter("keyboardpageIndex") != null
                        || request.getParameter("keyboardsortOrder") != null) {// click phan trang
                    if (request.getParameter("headPhonepageIndex") != null) {
                        headPhonepageIndex = Integer.parseInt(request.getParameter("headPhonepageIndex"));
                    } else {
                        headPhonepageIndex = (int) session.getAttribute("headPhonepageIndex");
                    }
                } else {// làn dau = null, các l?n click vao nut khac
                    ArrayList<Products> headPhoneData;
                    String searchInput = "";
                    String headPhonesortOrder = null;
                    String searchSubmit = request.getParameter("searchSubmit");
                    if (searchSubmit != null) {// click search
                        searchInput = request.getParameter("searchInput");
                        headPhonesortOrder = (String) session.getAttribute("headPhonesortOrder");
//                        out.print("e"); 
                        if (headPhonesortOrder == null) {
                            headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, "rate");
                        } else {
                            headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, headPhonesortOrder);
                        }
//                        return; 
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
                    } else {
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
                session.setAttribute("headPhonepageIndex", headPhonepageIndex);
            }

            ///mouse
            if (tab.equals("mouse") || tab.equals("allProduct")) {
                if (tab.equals("mouse")) {
                    request.setAttribute("tab", "mouse");
//                    session.setAttribute("tab", "mouse");
                } else {
//                    session.setAttribute("tab", "allProduct");
                    request.setAttribute("tab", "allProduct");
                }
                int mousepageIndex = 1;
                if (request.getParameter("mousepageIndex") != null
                        || request.getParameter("headPhonesortOrder") != null
                        || request.getParameter("headPhonepageIndex") != null
                        || request.getParameter("keyboardpageIndex") != null
                        || request.getParameter("keyboardsortOrder") != null) {// click phan trang
                    if (request.getParameter("mousepageIndex") != null) {
                        mousepageIndex = Integer.parseInt(request.getParameter("mousepageIndex"));
                    } else {
                        mousepageIndex = (int) session.getAttribute("mousepageIndex");
                    }
                } else {
                    ArrayList<Products> mouseData;
                    String searchInput = "";
                    String mousesortOrder = null;
                    String searchSubmit = request.getParameter("searchSubmit");
                    if (searchSubmit != null) {// click search
                        searchInput = request.getParameter("searchInput");
                        mousesortOrder = (String) session.getAttribute("mousesortOrder");
                        if (mousesortOrder == null) {
                            mouseData = pdao.getProductListByCategoryIDAndNameAndSort("3", searchInput, "rate");
                        } else {
                            mouseData = pdao.getProductListByCategoryIDAndNameAndSort("3", searchInput, mousesortOrder);
                        }
                    } else {//  click sortOrder //searchSubmit == null
                        mousesortOrder = request.getParameter("mousesortOrder");
                        if (mousesortOrder != null) {
                            searchInput = (String) session.getAttribute("searchInput");
                            mouseData = pdao.getProductListByCategoryIDAndNameAndSort("3", searchInput, mousesortOrder);
                        } else {// first time called sortorder= rate(default)
                            mouseData = pdao.getProductListByCategoryIDAndNameAndSort("3", searchInput, "rate");
                        }
                    }
                    session.setAttribute("mousesortOrder", mousesortOrder);
                    session.setAttribute("searchInput", searchInput);
                    session.setAttribute("mouseData", mouseData);
                    int mouseamountElementInPage;
                    if (request.getParameter("mouseamountElementInPage") != null) {
                        mouseamountElementInPage = Integer.parseInt(request.getParameter("mouseamountElementInPage"));
                    } else {
                        if (session.getAttribute("mouseamountElementInPage") == null) {
                            mouseamountElementInPage = 6;
                        } else {
                            mouseamountElementInPage = (int) session.getAttribute("mouseamountElementInPage");
                        }
                    }
                    session.setAttribute("mouseamountElementInPage", mouseamountElementInPage);
                    int mousepageAmount = mouseData.size() / mouseamountElementInPage;
                    if (mouseData.size() % mouseamountElementInPage != 0) {
                        ++mousepageAmount;
                    }
                    session.setAttribute("mousepageAmount", mousepageAmount);

                }
                session.setAttribute("mousepageIndex", mousepageIndex);
            }

            //keyboard
            if (tab.equals("keyboard") || tab.equals("allProduct")) {
                if (tab.equals("keyboard")) {
                    request.setAttribute("tab", "keyboard");
//                    session.setAttribute("tab", "keyboard");
                } else {
//                    session.setAttribute("tab", "allProduct");
                    request.setAttribute("tab", "allProduct");
                }
                int keyboardpageIndex = 1;
                if (request.getParameter("keyboardpageIndex") != null
                        || request.getParameter("headPhonesortOrder") != null
                        || request.getParameter("headPhonepageIndex") != null
                        || request.getParameter("mousesortOrder") != null
                        || request.getParameter("mousepageIndex") != null) {// click phan trang
                    if (request.getParameter("keyboardpageIndex") != null) {
                        keyboardpageIndex = Integer.parseInt(request.getParameter("keyboardpageIndex"));
                    } else {
                        keyboardpageIndex = (int) session.getAttribute("keyboardpageIndex");
                    }
                } else {
                    ArrayList<Products> keyboardData;
                    String searchInput = "";
                    String keyboardsortOrder = null;
                    String searchSubmit = request.getParameter("searchSubmit");
                    if (searchSubmit != null) {// click search
                        searchInput = request.getParameter("searchInput");
                        keyboardsortOrder = (String) session.getAttribute("keyboardsortOrder");
                        if (keyboardsortOrder == null) {
                            keyboardData = pdao.getProductListByCategoryIDAndNameAndSort("2", searchInput, "rate");
                        } else {
                            keyboardData = pdao.getProductListByCategoryIDAndNameAndSort("2", searchInput, keyboardsortOrder);
                        }
                    } else {//  click sortOrder //searchSubmit == null
                        keyboardsortOrder = request.getParameter("keyboardsortOrder");
                        if (keyboardsortOrder != null) {
                            searchInput = (String) session.getAttribute("searchInput");
                            keyboardData = pdao.getProductListByCategoryIDAndNameAndSort("2", searchInput, keyboardsortOrder);
                        } else {// first time called sortorder= rate(default)
                            keyboardData = pdao.getProductListByCategoryIDAndNameAndSort("2", searchInput, "rate");
                        }
                    }
                    session.setAttribute("keyboardsortOrder", keyboardsortOrder);
                    session.setAttribute("searchInput", searchInput);
                    session.setAttribute("keyboardData", keyboardData);
                    int keyboardamountElementInPage;
                    if (request.getParameter("keyboardamountElementInPage") != null) {
                        keyboardamountElementInPage = Integer.parseInt(request.getParameter("keyboardamountElementInPage"));
                    } else {
                        if (session.getAttribute("keyboardamountElementInPage") == null) {
                            keyboardamountElementInPage = 6;
                        } else {
                            keyboardamountElementInPage = (int) session.getAttribute("keyboardamountElementInPage");
                        }
                    }
                    session.setAttribute("keyboardamountElementInPage", keyboardamountElementInPage);
                    int keyboardpageAmount = keyboardData.size() / keyboardamountElementInPage;
                    if (keyboardData.size() % keyboardamountElementInPage != 0) {
                        ++keyboardpageAmount;
                    }
                    session.setAttribute("keyboardpageAmount", keyboardpageAmount);
                }
                session.setAttribute("keyboardpageIndex", keyboardpageIndex);
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
