/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Categories;
import Model.Products;
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
    private Products OneProduct = null;

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

    public Products getOneProduct() {
        return OneProduct;
    }

    public void setOneProduct(Products OneProduct) {
        this.OneProduct = OneProduct;
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

    public void addNewProduct(String cid, String pname, String desciption, String img, String quantity, String status, String price) {
        try {
            String sql = "insert into product (product_categoryID, name, desciption, picture, price, quantity, status)\n"
                    + "values (?, ?, ?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, cid);
            pstm.setString(2, pname);
            pstm.setString(3, desciption);
            pstm.setString(4, img);
            pstm.setString(5, price);
            pstm.setString(6, quantity);
            pstm.setString(7, status);

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

    public static void main(String[] args) {
        ManagerDAO dao = new ManagerDAO();
        System.out.println(dao.getAllProduct().get(1));
    }
}
