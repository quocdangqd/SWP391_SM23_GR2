/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author trand
 */
public class OrderDetail {

    private String orderdetaiID, orderdetail_orderID, quantity, price, orderdetail_productID, product_rate;

    public OrderDetail() {
    }

    public OrderDetail(String orderdetaiID, String orderdetail_orderID, String quantity, String price, String orderdetail_productID, String product_rate) {
        this.orderdetaiID = orderdetaiID;
        this.orderdetail_orderID = orderdetail_orderID;
        this.quantity = quantity;
        this.price = price;
        this.orderdetail_productID = orderdetail_productID;
        this.product_rate = product_rate;
    }

    public String getOrderdetaiID() {
        return orderdetaiID;
    }

    public void setOrderdetaiID(String orderdetaiID) {
        this.orderdetaiID = orderdetaiID;
    }

    public String getOrderdetail_orderID() {
        return orderdetail_orderID;
    }

    public void setOrderdetail_orderID(String orderdetail_orderID) {
        this.orderdetail_orderID = orderdetail_orderID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderdetail_productID() {
        return orderdetail_productID;
    }

    public void setOrderdetail_productID(String orderdetail_productID) {
        this.orderdetail_productID = orderdetail_productID;
    }

    public String getProduct_rate() {
        return product_rate;
    }

    public void setProduct_rate(String product_rate) {
        this.product_rate = product_rate;
    }

}
