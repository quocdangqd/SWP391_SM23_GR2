/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.OrderDetail;
import java.util.ArrayList;

/**
 *
 * @author trand
 */
public class OrderDetailDAO extends ConnectMySQL{
    public ArrayList<OrderDetail> GetOrderDetailList() {
        ArrayList<OrderDetail> data = new ArrayList<>();
        try {
            String sqlSelectString = "SELECT * FROM swp.orderdetail;";
            pstm = connection.prepareStatement(sqlSelectString);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderdetailID = String.valueOf(rs.getInt(1));
                String orderdetai_orderID = String.valueOf(rs.getInt(2));
                String quantity = String.valueOf(rs.getInt(3));
                String price = String.valueOf(rs.getInt(4));
                String orderdetai_productID = String.valueOf(rs.getInt(5));
                String product_rate = String.valueOf(rs.getInt(6));
                data.add(new OrderDetail(orderdetailID, orderdetai_orderID, quantity, price, orderdetai_productID, product_rate));
            }
        } catch (Exception e) {
            System.out.println("GetCategoriesesList: " + e);
        }
        return data;
    }
    
    public OrderDetail getOrderDetailById(String ID) {
        try {
            String sqlSelectString = "select * from Orderdetail where orderdetailID =?";
            pstm = connection.prepareStatement(sqlSelectString);
            pstm.setInt(1, Integer.parseInt(ID));
            rs = pstm.executeQuery();
            if(rs.next()){
                String orderdetailID = String.valueOf(rs.getInt(1));
                String orderdetai_orderID = String.valueOf(rs.getInt(2));
                String quantity = String.valueOf(rs.getInt(3));
                String price = String.valueOf(rs.getInt(4));
                String orderdetai_productID = String.valueOf(rs.getInt(5));
                String product_rate = String.valueOf(rs.getInt(6));
                OrderDetail data = new OrderDetail(orderdetailID, orderdetai_orderID, quantity, price, orderdetai_productID, product_rate);
                return data;
            }
        } catch (Exception e) {
            System.out.println("GetCategoriesesList: " + e);
        }
        return null;
    }
}
