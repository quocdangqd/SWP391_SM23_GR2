/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class Products {
    private String ProductID, product_categoryID, name, desciption, picture, price, quantity, status,sale;
    private String rateStar,salePrice;
    

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getRateStar() {
        return rateStar;
    }

    public void setRateStar(String rateStar) {
        this.rateStar = rateStar;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }
    public Products() {
    }

    public Products(String ProductID, String product_categoryID, String name, String desciption, String picture, String price, String quantity, String status) {
        this.ProductID = ProductID;
        this.product_categoryID = product_categoryID;
        this.name = name;
        this.desciption = desciption;
        this.picture = picture;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public Products(String ProductID, String product_categoryID, String name, String desciption, String picture, String price, String quantity, String status, String sale, String rateStar, String salePrice) {
        this.ProductID = ProductID;
        this.product_categoryID = product_categoryID;
        this.name = name;
        this.desciption = desciption;
        this.picture = picture;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.sale = sale;
        this.rateStar = rateStar;
        this.salePrice = salePrice;
    }

    
    
    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProduct_categoryID() {
        return product_categoryID;
    }

    public void setProduct_categoryID(String product_categoryID) {
        this.product_categoryID = product_categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}