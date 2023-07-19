package Dal;

<<<<<<< HEAD
import Model.Order;
import Model.Products;
=======
import Model.Saler;
>>>>>>> parent of 40de08a (full)
import Model.User;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author trand
 */
public class SalerDAO extends ConnectMySQL {

    private ArrayList<Products> product;
    private ArrayList<Order> order;
    private ArrayList<User> user;

    public SalerDAO() {
    }

    public ArrayList<Products> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Products> product) {
        this.product = product;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

<<<<<<< HEAD
    public ArrayList<Order> getNewOrder() {
        order = new ArrayList<>();
        String sql = "select o.*,u.name,od.price from swp.order o, swp.orderdetail od, swp.user u\n"
                + "where od.orderdetail_orderID=o.orderID and u.userID=o.order_userID ORDER BY date DESC LIMIT 5;";
=======
//    public List<User> getAllSaler() {
//        List<User> data = new ArrayList<>();
//        String sql = "select name from user u "
//                + "JOIN saler i on u.userID = i.saler_userID";
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
//        decimalFormat.applyPattern("#,###");
//        try {
//            pstm = connection.prepareStatement(sql);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
////                String orderID = String.valueOf(rs.getInt(1));
////                String name = String.valueOf(rs.getString(2));
//            }
//        } catch (Exception e) {
//        }
//        return user;
//    }

    public ArrayList<User> getAllUserSaler() {
        user = new ArrayList<>();
        String sql = "select * from swp.order o JOIN saler s on o.order_saleID = s.salerID where salerID = 1";
>>>>>>> parent of 40de08a (full)
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
        decimalFormat.applyPattern("#,###");
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderID = String.valueOf(rs.getInt(1));
<<<<<<< HEAD
                String order_userID = String.valueOf(rs.getInt(2));
                String sale = String.valueOf(rs.getInt(3));
                String note = String.valueOf(rs.getString(4));
                String date = String.valueOf(rs.getTimestamp(5));
                String status = rs.getString(6);
                String name_user = rs.getString(7);
                String price_order = String.valueOf(decimalFormat.format((int) rs.getFloat(8)));
                order.add(new Order(orderID, order_userID, order_userID, note, date, status, name_user, price_order));
            }

        } catch (Exception e) {
            System.out.println("getListOrder: " + e.getMessage());
        }
        return order;
    }

    public ArrayList<User> getNewCustomer() {
        user = new ArrayList<>();
        String sql = "SELECT userID, username, age, phone_number, email, address FROM swp.user\n"
                + "where user_roleID = 3";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getInt(1));
                String username = String.valueOf(rs.getString(2));
                String pass = String.valueOf(rs.getString(3));
                String role = String.valueOf(rs.getInt(4));
                String name = String.valueOf(rs.getString(5));
                String age = String.valueOf(rs.getInt(6));
                String sex = String.valueOf(rs.getInt(7));
                String address = String.valueOf(rs.getString(8));
                String phone = String.valueOf(rs.getString(9));
                String avata = String.valueOf(rs.getString(10));
                String registercode = String.valueOf(rs.getString(11));
                String email = String.valueOf(rs.getString(12));
                String status = String.valueOf(rs.getInt(13));
                user.add(new User(userID, username, pass, userID, name, age, userID, address, phone, avata, registercode, email, status));
            }
        } catch (Exception e) {
            System.out.println("getListOrder: " + e.getMessage());
        }
        return user;
=======
                String name = String.valueOf(rs.getString(2));
                String price = String.valueOf(rs.getInt(3));
                String status = String.valueOf(rs.getString(4));
             //   user.add(new User);
            }
        } catch (Exception e) {
        }
        return user;
    }

    public static void main(String[] args) {
        SalerDAO dao = new SalerDAO();
        System.out.println(dao.getAllUserSaler());
>>>>>>> parent of 40de08a (full)
    }
}
