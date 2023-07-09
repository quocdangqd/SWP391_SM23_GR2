/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Order;
import Model.Products;
import Model.User;
import java.sql.Timestamp;
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
    private ArrayList<Order> order;

    public ManagerDAO() {
    }

    public ArrayList<Products> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Products> product) {
        this.product = product;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
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
                String picture2 = String.valueOf(rs.getString(6));
                String picture3 = String.valueOf(rs.getString(7));
                String price = String.valueOf(decimalFormat.format((int) rs.getFloat(8)));
                String quantity = String.valueOf(rs.getInt(9));
                String status = String.valueOf(rs.getInt(10));
                product.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, "", "", "", picture2, picture3));
            }

        } catch (Exception e) {
            System.out.println("getAllProduct: " + e.getMessage());
        }
        return product;
    }

    public Products getProductsByID(String id) {
        try {
            String sqlSelect = "Select * from product where ProductID=" + id;
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            while (rs.next()) {
                Products p = new Products();
                p.setProductID(String.valueOf(rs.getInt(1)));
                String categories = String.valueOf(rs.getInt(2));
                p.setProduct_categoryID(categories);

                p.setName(String.valueOf(rs.getString(3)));
                p.setDesciption(String.valueOf(rs.getString(4)));
                p.setPicture(rs.getString(5));
                p.setPicture2(rs.getString(6));
                p.setPicture3(rs.getString(7));
                p.setPrice(String.valueOf(decimalFormat.format((int) rs.getFloat(8))));
                p.setQuantity(String.valueOf(rs.getInt(9)));
                p.setStatus(String.valueOf(rs.getInt(10)));
                p.setCategories(new CategoriesDAO().getCategoryById(categories));
                return p;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
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

    public void updateProduct(String cid, String pname, String desciption, String img1, String img2, String img3, String quantity, String status, String price, String pid) {
        try {
            String sql = "UPDATE product set product_categoryID=?, name=?, desciption=?,picture=?,picture2=?,picture3=?,\n"
                    + "price=?,quantity=?, status=? where ProductID = ?;";
            pstm = connection.prepareStatement(sql);
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            pstm.setInt(1, Integer.parseInt(cid));
            pstm.setString(2, pname);
            pstm.setString(3, desciption);
            pstm.setString(4, img1);
            pstm.setString(5, img2);
            pstm.setString(6, img3);
            pstm.setFloat(7, Float.parseFloat(price));
            pstm.setInt(8, Integer.parseInt(quantity));
            pstm.setBoolean(9, status.equals("1"));
            pstm.setInt(10, Integer.parseInt(pid));

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateProduct: " + e.getMessage());

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

    public ArrayList<Order> getListOrder() {
        order = new ArrayList<>();
        String sql = "SELECT * FROM swp.order;";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderID = String.valueOf(rs.getString(1));
                String order_userID = String.valueOf(rs.getString(2));
                String sale = String.valueOf(rs.getString(3));
                String note = String.valueOf(rs.getString(4));
                String date = String.valueOf(rs.getTimestamp(5));
                String status = rs.getString(6);
                order.add(new Order(orderID, order_userID, sale, note, date, status));
            }

        } catch (Exception e) {
            System.out.println("getListOrder: " + e.getMessage());
        }
        return order;
    }

    public Order getOrderByID(String id) {
        try {
            String sqlSelect = "SELECT * FROM swp.order where orderID=" + id;
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderID(String.valueOf(rs.getInt(1)));
                String user = String.valueOf(rs.getString(2));
                o.setOrder_userID(user);
                o.setOrder_salecodeID(String.valueOf(rs.getString(3)));
                o.setDate(String.valueOf(rs.getTimestamp(5)));
                o.setStatus(String.valueOf(rs.getString(6)));
                o.setUser(new ManagerDAO().getUserById(user));
                return o;
            }
        } catch (Exception e) {
            System.out.println("getOrderByID: " + e.getMessage());
        }

        return null;
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

    public void updateOrder(String orderID, String date, String order_userID, String note, String order_salecodeID, String status) {
        try {
            String sql = "update swp.order set date=?, order_userID=?, note=?, order_salecodeID=?, status=?\n"
                    + "	where orderID = ?;";
            pstm = connection.prepareStatement(sql);
            pstm.setTimestamp(1, Timestamp.valueOf(date));
            pstm.setString(2, order_userID);
            pstm.setString(3, note);
            pstm.setString(4, order_salecodeID);
            pstm.setString(5, status);
            pstm.setString(6, orderID);

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateOrder: " + e.getMessage());

        }
    }
//
//    public void addNewOrder(String order_shippingID, String date, String order_userID, String note, String order_salecodeID, String status) {
//        try {
//            String sql = "insert into swp.order (order_shippingID, date, order_userID, note, order_salecodeID, status)\n"
//                    + "  values (?,?,?,?,?,?);";
//            pstm = connection.prepareStatement(sql);
//            pstm.setString(1, order_shippingID);
//            pstm.setString(2, date);
//            pstm.setString(3, order_userID);
//            pstm.setString(4, note);
//            pstm.setString(5, order_salecodeID);
//            pstm.setString(6, status);
//
//            pstm.executeUpdate();
//        } catch (Exception e) {
//            System.out.println("addNewOrder: " + e.getMessage());
//
//        }
//    }

    public ArrayList<User> getUserList() {
        ArrayList<User> data = new ArrayList<>();
        try {
            String sqlSelectString = "SELECT * FROM swp.user;";
            pstm = connection.prepareStatement(sqlSelectString);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getString(1));
                String name = String.valueOf(rs.getString(5));
                String address = String.valueOf(rs.getString(8));
                String phone_number = String.valueOf(rs.getInt(9));
                String email = String.valueOf(rs.getString(12));
                data.add(new User(userID, name, address, phone_number, email));
            }
        } catch (Exception e) {
            System.out.println("getUserList: " + e);
        }
        return data;
    }

    public User getUserById(String id) {
        try {
            String sqlSelectString = "SELECT * FROM swp.user where userID=?;";
            pstm = connection.prepareStatement(sqlSelectString);
            pstm.setInt(1, Integer.parseInt(id));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getString(1));
                String name = String.valueOf(rs.getString(5));
                String address = String.valueOf(rs.getString(8));
                String phone_number = String.valueOf(rs.getInt(9));
                String email = String.valueOf(rs.getString(12));
                return new User(userID, name, address, phone_number, email);
            }
        } catch (Exception e) {
            System.out.println("getUserById: " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        ManagerDAO dao = new ManagerDAO();
        Products p = dao.getProductsByID("1");
//        dao.updateProduct(p.getProduct_categoryID(), p.getName(), p.getDesciption(), p.getPicture(), p.getPicture2(),
//                 p.getPicture3(), "438", p.getStatus(), p.getPrice(), p.getProductID());

        System.out.println(dao.getUserList().get(9));
        System.out.println(dao.getAllProduct().get(1));

    }
}
