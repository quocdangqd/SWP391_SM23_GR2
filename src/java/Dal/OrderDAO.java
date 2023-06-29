package Dal;

import Model.Order;
import Model.OrderDetail;
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

    public ArrayList<Order> totalOfOrder() {
        ArrayList<Order> data = new ArrayList<>();
        try {
            String sqlSelect = "SELECT *"
                    + "FROM swp.order o\n"
                    + "join swp.user u\n"
                    + "on o.order_userID = u.userID\n"
                    + "join swp.orderdetail od\n"
                    + "on o.orderID = od.orderdetail_orderID\n"
                    + "join product p\n"
                    + "on od.orderdetail_productID = p.ProductID\n";
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderID(String.valueOf(rs.getInt(1)));
                String user = String.valueOf(rs.getInt(2));
                String orderdetail = String.valueOf(rs.getInt(3));
                String product = String.valueOf(rs.getInt(4));
                o.setOrder_userID(String.valueOf(rs.getInt(5)));
                o.setOrder_salecodeID(String.valueOf(rs.getInt(6)));
                o.setNote(rs.getString(7));
                o.setDate(rs.getString(8));
                o.setStatus(rs.getString(9));
                o.setUser(new UserDAO().getUserById(user));
                o.setOrderDetail(new OrderDetailDAO().getOrderDetailById(orderdetail));
                o.setProducts(new ProductDAO().getProductsByID(product));
                data.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
    
    public static void main(String[] args) {
        OrderDAO odao = new OrderDAO();
        ArrayList list = new ArrayList();
        list = odao.totalOfOrder();
        System.out.println(list);
    }
}
