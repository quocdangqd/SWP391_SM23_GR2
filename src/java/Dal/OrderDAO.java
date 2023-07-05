package Dal;

import Model.Order;
import Model.OrderDetail;
import Model.Products;
import Model.User;
import java.util.ArrayList;

public class OrderDAO extends ConnectMySQL {

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

    public int countCancelOrder() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM swp.order\n"
                + "where status = '0'";
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

//    public ArrayList<Order> totalOfOrder() {
//        ArrayList<Order> data = new ArrayList<>();
//        try {
//            String sqlSelect = "SELECT o.orderID, u.name, p.name, od.quantity, sum(od.quantity*p.price) as 'tong'\n"
//                    + "FROM swp.order o\n"
//                    + "join swp.user u\n"
//                    + "on o.order_userID = u.userID\n"
//                    + "join swp.orderdetail od\n"
//                    + "on o.orderID = od.orderdetail_orderID\n"
//                    + "join product p\n"
//                    + "on od.orderdetail_productID = p.ProductID\n"
//                    + "group by o.orderID, u.name, p.name, od.quantity";
//            pstm = connection.prepareStatement(sqlSelect);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                Order o = new Order();
//                User u = new User();
//                Products p = new Products();
//                OrderDetail od = new OrderDetail();
//                o.setOrderID(String.valueOf(rs.getInt(1)));
//                u.setName(rs.getString(2));
//                p.setName(rs.getString(3));
//                od.setQuantity(String.valueOf(rs.getInt(4)));
//                od.setPrice(String.valueOf(rs.getFloat(5)));
//                data.add(o);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return data;
//    }

    public static void main(String[] args) {
//        OrderDAO odao = new OrderDAO();
//        ArrayList list = new ArrayList();
//        list = odao.totalOfOrder();
//        System.out.println(list);
    }
}
