package Dal;

import Model.Order;
import java.util.ArrayList;

public class OrderDAO extends ConnectMySQL {
    
    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> data = new ArrayList<>();
        String sqlSelect = "SELECT * FROM swp.order";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderId(rs.getInt(1));
                o.setUserId(rs.getInt(4));
                o.setNote(rs.getString(5));
                o.setSalecode(rs.getInt(6));
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
}
