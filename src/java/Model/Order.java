/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class Order {

    private String orderID, order_userID, order_salecodeID, note, date, status;
    private String address, phone_number, orderdetail_productID;

    public Order() {
    }

    public Order(String orderID, String order_userID, String order_salecodeID, String note, String date, String status) {
        this.orderID = orderID;
        this.order_userID = order_userID;
        this.order_salecodeID = order_salecodeID;
        this.note = note;
        this.date = date;
        this.status = status;
    }

    public Order(String order_userID, String order_salecodeID, String date, String status) {
        this.order_userID = order_userID;
        this.order_salecodeID = order_salecodeID;
        this.date = date;
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getOrderdetail_productID() {
        return orderdetail_productID;
    }

    public void setOrderdetail_productID(String orderdetail_productID) {
        this.orderdetail_productID = orderdetail_productID;
    }

    public Order(String orderID, String order_userID, String order_salecodeID, String note, String date, String status, String address, String phone_number, String orderdetail_productID) {
        this.orderID = orderID;
        this.order_userID = order_userID;
        this.order_salecodeID = order_salecodeID;
        this.note = note;
        this.date = date;
        this.status = status;
        this.address = address;
        this.phone_number = phone_number;
        this.orderdetail_productID = orderdetail_productID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrder_userID() {
        return order_userID;
    }

    public void setOrder_userID(String order_userID) {
        this.order_userID = order_userID;
    }

    public String getOrder_salecodeID() {
        return order_salecodeID;
    }

    public void setOrder_salecodeID(String order_salecodeID) {
        this.order_salecodeID = order_salecodeID;
    }

    public String getNote() {
        return note;
    }
    

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", order_shippingID=" + order_shippingID + ", order_userID=" + order_userID + ", note=" + note + ", order_salecodeID=" + order_salecodeID + ", status=" + status + ", date=" + date + '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
