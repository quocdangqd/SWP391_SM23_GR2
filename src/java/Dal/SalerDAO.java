package Dal;

import Model.Saler;
import Model.User;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author trand
 */
public class SalerDAO extends ConnectMySQL {

    private ArrayList<User> user;

    public SalerDAO() {
    }

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

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
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
        decimalFormat.applyPattern("#,###");
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderID = String.valueOf(rs.getInt(1));
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
    }
}
