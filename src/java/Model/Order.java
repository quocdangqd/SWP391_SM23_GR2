/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author laptop
 */
public class Order {
    private String orderID, order_shippingID, order_userID, note, order_salecodeID, status;
    private String date;
    
    public Order() {
    }

    public Order(String orderID, String order_shippingID, String order_userID, String note, String order_salecodeID, String status, String date) {
        this.orderID = orderID;
        this.order_shippingID = order_shippingID;
        this.order_userID = order_userID;
        this.note = note;
        this.order_salecodeID = order_salecodeID;
        this.status = status;
        this.date = date;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrder_shippingID() {
        return order_shippingID;
    }

    public void setOrder_shippingID(String order_shippingID) {
        this.order_shippingID = order_shippingID;
    }

    public String getOrder_userID() {
        return order_userID;
    }

    public void setOrder_userID(String order_userID) {
        this.order_userID = order_userID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrder_salecodeID() {
        return order_salecodeID;
    }

    public void setOrder_salecodeID(String order_salecodeID) {
        this.order_salecodeID = order_salecodeID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", order_shippingID=" + order_shippingID + ", order_userID=" + order_userID + ", note=" + note + ", order_salecodeID=" + order_salecodeID + ", status=" + status + ", date=" + date + '}';
    }

        
    
}
