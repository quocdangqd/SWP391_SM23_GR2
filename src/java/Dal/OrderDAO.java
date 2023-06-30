/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Order;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
            pstm=connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(userID));
            rs=pstm.executeQuery();
            while (rs.next()) {                
                String orderID=String.valueOf(rs.getInt(1));
                String order_userID=String.valueOf(rs.getInt(2));
                String order_salecodeID=String.valueOf(rs.getInt(3));
                String note=String.valueOf(rs.getString(4));
                String date=String.valueOf(rs.getTimestamp(5));
                String status=String.valueOf(rs.getString(6));
                return  new Order(orderID, order_userID, order_salecodeID, note, date, status);
            }
        } catch (Exception e) {
            System.out.println("getOrderAfterAdd: " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        Timestamp datetime = new Timestamp(System.currentTimeMillis());
        Order order = new Order("10", "2", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datetime), "Pending");
        orderDAO.addOrder(order);
        order = orderDAO.getOrderAfterAddByUserID("10");
        System.out.println(order.getOrderID());
    }
}
