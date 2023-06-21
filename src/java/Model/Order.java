/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author trand
 */
public class Order {
    private int orderId, order_shippingId;
    private int userId;
    private Date date;
    private String note;
    private int salecode;
    private String status;

    public Order() {
    }

    public Order(int orderId, int order_shippingId, int userId, Date date, String note, int salecode, String status) {
        this.orderId = orderId;
        this.order_shippingId = order_shippingId;
        this.userId = userId;
        this.date = date;
        this.note = note;
        this.salecode = salecode;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrder_shippingId() {
        return order_shippingId;
    }

    public void setOrder_shippingId(int order_shippingId) {
        this.order_shippingId = order_shippingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getSalecode() {
        return salecode;
    }

    public void setSalecode(int salecode) {
        this.salecode = salecode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
