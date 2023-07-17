/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Order;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class OrderDAO extends ConnectMySQL {

    public boolean addOrder(Order order) {
        try {
            String sqlSelect;
            if (order.getOrder_salecodeID() != null) {
                sqlSelect = "INSERT INTO `swp`.`order` (`order_userID`, `order_salecodeID`, `date`, `status`)\n"
                        + " VALUES (?, ?, ?, ?);";
                pstm = connection.prepareStatement(sqlSelect);
                pstm.setInt(1, Integer.parseInt(order.getOrder_userID()));
                pstm.setInt(2, Integer.parseInt(order.getOrder_salecodeID()));
                pstm.setTimestamp(3, Timestamp.valueOf(order.getDate()));
                pstm.setString(4, order.getStatus());
                pstm.execute();
            } else {
                sqlSelect = "INSERT INTO `swp`.`order` (`order_userID`,`date`, `status`)\n"
                        + " VALUES (?, ?, ?);";
                pstm = connection.prepareStatement(sqlSelect);
                pstm.setInt(1, Integer.parseInt(order.getOrder_userID()));
                pstm.setTimestamp(2, Timestamp.valueOf(order.getDate()));
                pstm.setString(3, order.getStatus());
                pstm.execute();
            }
            return true;
        } catch (Exception e) {
            System.out.println("addOrder: " + e);
        }
        return false;
    }

    public Order getOrderAfterAddByUserID(String userID) {
        try {
            String sqlSelect = " SELECT * FROM swp.order where order_userID=? \n"
                    + " order by date desc\n"
                    + " limit 1;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(userID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderID = String.valueOf(rs.getInt(1));
                String order_userID = String.valueOf(rs.getInt(2));
                String order_salecodeID = String.valueOf(rs.getInt(3));
                String note = String.valueOf(rs.getString(4));
                String date = String.valueOf(rs.getTimestamp(5));
                String status = String.valueOf(rs.getString(6));
                return new Order(orderID, order_userID, order_salecodeID, note, date, status);
            }
        } catch (Exception e) {
            System.out.println("getOrderAfterAdd: " + e);
        }
        return null;
    }

    public Order getOrderInTracking(String orderID, String orderdetail_productID) {
        try {
            String sqlSelect = "select o.orderID, o.order_userID, o.order_salecodeID, o.note, o.date, o.status, u.address,u.phone_number,od.orderdetail_productID\n"
                    + "     from `order` o, user u,orderdetail od \n"
                    + "     where o.order_userID = u.userID and od.orderdetail_orderID=o.orderID and o.orderID =? and od.orderdetail_productID=?";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(orderID));
            pstm.setInt(2, Integer.parseInt(orderdetail_productID));
            rs = pstm.executeQuery();
            while (rs.next()) {
//                String orderID = String.valueOf(rs.getInt(1));
                String order_userID = String.valueOf(rs.getInt(2));
                String order_salecodeID = String.valueOf(rs.getInt(3));
                String note = String.valueOf(rs.getString(4));
                String date = String.valueOf(rs.getTimestamp(5));
                String status = String.valueOf(rs.getString(6));
                String address = String.valueOf(rs.getString(7));
                String phone_number = String.valueOf(rs.getString(8));
                return new Order(orderID, order_userID, order_salecodeID, note, date, status, address, phone_number, orderdetail_productID);
            }
        } catch (Exception e) {
            System.out.println("getOrderInTracking: " + e);
        }
        return null;
    }
    
    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> data = new ArrayList<>();
        String sqlSelect = "SELECT * FROM swp.order";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderID(String.valueOf(rs.getInt(1)));
                o.setOrder_userID(String.valueOf(rs.getInt(4)));
                o.setNote(rs.getString(5));
                data.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    public int CountOrder() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM swp.order";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public int CountOrderCancelled() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM swp.order\n"
                + "where status = 'Cancelled'";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
//        Timestamp datetime = new Timestamp(System.currentTimeMillis());
//        Order order = new Order("10", "2", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datetime), "Pending");
//        orderDAO.addOrder(order);
//        order = orderDAO.getOrderAfterAddByUserID("10");
//        System.out.println(order.getOrderID());
        System.out.println(orderDAO.getOrderInTracking("77", "2").getAddress());
    }
}
