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

    public ArrayList<Order> GetOrderListByUserID(String userID) {
        ArrayList<Order> data = new ArrayList<>();
        try {
            String sqlSelect;
            sqlSelect = "SELECT  p.name,p.picture, u.address, o.date,o.status, od.price-od.price*coalesce(salecodeRate/100,0), od.quantity\n"
                    + "FROM swp.user u, swp.orderdetail od, swp.product p ,swp.order o left outer join swp.salecode sc on o.order_salecodeID=sc.salecodeID\n"
                    + "WHERE u.userID = o.order_userID and od.orderdetail_orderID = o.orderID \n"
                    + "and p.ProductID = od.orderdetail_productID  and userID =?";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(userID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String productName = rs.getString(1);
                String picture = rs.getString(2);
                String address = rs.getString(3);
                String date = String.valueOf(rs.getTimestamp(4)).substring(0, 10);
                SimpleDateFormat sfDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                date = new SimpleDateFormat("dd-MM-yyyy").format(sfDateFormat.parse(date));
                String status = rs.getString(5);
                String salePrice = String.valueOf(rs.getDouble(6));
                String quantity = String.valueOf(rs.getInt(7));
                data.add(new Order(date, status, address, picture, salePrice, quantity, productName));
            }
            return data;
        } catch (Exception e) {
            System.out.println("addOrder: " + e);
        }
        return null;
    }

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

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
//        Timestamp datetime = new Timestamp(System.currentTimeMillis());
//        Order order = new Order("10", "2", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datetime), "Pending");
//        orderDAO.addOrder(order);
//        order = orderDAO.getOrderAfterAddByUserID("10");
//        System.out.println(order.getOrderID());
//        System.out.println(orderDAO.getOrderInTracking("77", "2").getAddress());
        System.out.println(orderDAO.GetOrderListByUserID("6").size());
        System.out.println(orderDAO.GetOrderListByUserID("6").get(0).getDate());
        System.out.println(orderDAO.GetOrderListByUserID("6").get(1).getDate());
    }
}
