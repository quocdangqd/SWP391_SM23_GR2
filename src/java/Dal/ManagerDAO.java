/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Categories;
import Model.Order;
import Model.Products;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author laptop
 */
public class ManagerDAO extends ConnectMySQL {

    private ArrayList<Products> product;
    private ArrayList<Categories> category;
    private ArrayList<Order> order;
    private Products OneProduct = null;
    private Order OneOrder = null;

    public ManagerDAO() {
    }

    public ArrayList<Products> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Products> product) {
        this.product = product;
    }

    public ArrayList<Categories> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<Categories> category) {
        this.category = category;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }

    public Products getOneProduct() {
        return OneProduct;
    }

    public void setOneProduct(Products OneProduct) {
        this.OneProduct = OneProduct;
    }

    public Order getOneOrder() {
        return OneOrder;
    }

    public void setOneOrder(Order OneOrder) {
        this.OneOrder = OneOrder;
    }

    public ArrayList<Products> getAllProduct() {
        product = new ArrayList<>();
        String sql = "SELECT * FROM swp.product;";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getInt(1));
                String product_categoryID = String.valueOf(rs.getInt(2));
                String name = String.valueOf(rs.getString(3));
                String desciption = String.valueOf(rs.getString(4));
                String picture = String.valueOf(rs.getString(5));
                String price = String.valueOf(decimalFormat.format((int) rs.getFloat(8)));
                String quantity = String.valueOf(rs.getInt(9));
                String status = String.valueOf(rs.getInt(10));
                product.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status));
            }

        } catch (Exception e) {
            System.out.println("getAllProduct: " + e.getMessage());
        }
        return product;
    }

    public void addNewProduct(String cid, String pname, String desciption, String img1, String img2, String img3, String quantity, String status, String price) {
        try {
            String sql = "insert into product (product_categoryID, name, desciption, picture, picture2, picture3, price, quantity, status)\n"
                    + "values (?, ?, ?, ?,?, ?, ?, ?, ?);";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, cid);
            pstm.setString(2, pname);
            pstm.setString(3, desciption);
            pstm.setString(4, img1);
            pstm.setString(5, img2);
            pstm.setString(6, img3);
            pstm.setString(7, price);
            pstm.setString(8, quantity);
            pstm.setString(9, status);

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("addNewProduct: " + e.getMessage());

        }
    }

    public void LoadOneProduct(String pid) {
        String sql = "select * from Product where ProductID=?";
        OneProduct = new Products();
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, pid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                OneProduct = (new Products(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            System.out.println("LoadOneProduct: " + e.getMessage());
        }
    }

    public void updateProduct(String pid, String cid, String pname, String desciption, String img, String quantity, String status, String price) {
        try {
            String sql = "UPDATE product set product_categoryID=?, name=?, desciption=?,picture=?, \n"
                    + "price=?,quantity=?, status=? where ProductID = ?;";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, cid);
            pstm.setString(2, pname);
            pstm.setString(3, desciption);
            pstm.setString(4, img);
            pstm.setString(5, price);
            pstm.setString(6, quantity);
            pstm.setString(7, status);
            pstm.setString(8, pid);

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("addNewProduct: " + e.getMessage());

        }
    }

    public void deleteProduct(String productID) {
        try {
            String sql = "delete from Product where ProductID=?;";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, productID);
            pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("deleteProduct: " + e.getMessage());

        }
    }

//    public Products getProductById(String id) {
//        String query = "select * from Products where ProductID=?";
//        try {
//            pstm = connection.prepareStatement(query);
//            pstm.setString(1, id);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                return (new Products(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10),
//                        rs.getString(11),
//                        rs.getString(12),
//                        rs.getString(13)));
//            }
//            
//        } catch (Exception e) {
//            System.out.println("getProductById: " + e.getMessage());
//        }
//        return null;
//    }
    public ArrayList<Order> getListOrder() {
        order = new ArrayList<>();
        String sql = "SELECT * FROM swp.order;";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderID = rs.getString(1);
                String order_userID = rs.getString(4);
                String order_salecodeID = rs.getString(6);
                String order_shippingID = rs.getString(2);
                Date date = rs.getDate(3);
                String status = rs.getString(7);
                order.add(new Order(orderID, order_shippingID, order_userID, "", order_salecodeID, status, String.valueOf(date)));
            }

        } catch (Exception e) {
            System.out.println("getListOrder: " + e.getMessage());
        }
        return order;
    }

    public void deleteOrder(String orderID) {
        try {
            String sql = "delete FROM swp.order where orderID=?;";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, orderID);
            pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("deleteOrder: " + e.getMessage());

        }
    }

    public void LoadOneOrder(String id) {
        String sql = "SELECT * FROM swp.order where orderID=?;";
        OneOrder = new Order();
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderID = rs.getString(1);
                String order_userID = rs.getString(4);
                String order_salecodeID = rs.getString(6);
                String order_shippingID = rs.getString(2);
                Date date = rs.getDate(3);
                String status = rs.getString(7);
                OneOrder = (new Order(orderID, order_shippingID, order_userID, "", order_salecodeID, status, String.valueOf(date)));
            }
        } catch (Exception e) {
            System.out.println("LoadOneOrder: " + e.getMessage());
        }
    }

    public void updateOrder(String orderID, String order_shippingID, String date, String order_userID, String note, String order_salecodeID, String status) {
        try {
            String sql = "update swp.order set order_shippingID=?, date=?, order_userID=?, note=?, order_salecodeID=?, status=?\n"
                    + "	where orderID = ?;";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, order_shippingID);
            pstm.setString(2, String.valueOf(date));
            pstm.setString(3, order_userID);
            pstm.setString(4, note);
            pstm.setString(5, order_salecodeID);
            pstm.setString(6, status);
            pstm.setString(7, orderID);

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateOrder: " + e.getMessage());

        }
    }

    public void addNewOrder(String order_shippingID, String date, String order_userID, String note, String order_salecodeID, String status) {
        try {
            String sql = "insert into swp.order (order_shippingID, date, order_userID, note, order_salecodeID, status)\n"
                    + "  values (?,?,?,?,?,?);";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, order_shippingID);
            pstm.setString(2, date);
            pstm.setString(3, order_userID);
            pstm.setString(4, note);
            pstm.setString(5, order_salecodeID);
            pstm.setString(6, status);

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("addNewOrder: " + e.getMessage());

        }
    }

    public static void main(String[] args) {
        ManagerDAO dao = new ManagerDAO();
//        System.out.println(dao.getAllProduct().get(1));

    }
}
