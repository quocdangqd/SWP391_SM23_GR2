package Dal;

import Model.Cart;
import java.util.ArrayList;

/**
 *
 * @author DucPhaoLo
 */
public class CartDAO extends ConnectMySQL {

    public boolean DeleteCartByID(String cartID) {
        try {
            String sqlSelect = "DELETE FROM `swp`.`cart` WHERE (`cartID` = ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(cartID));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("DeleteCartByID: " + e);
        }
        return false;
    }

    public boolean AddCart(Cart cart) {
        try {
            String sqlSelect = "INSERT INTO `swp`.`cart` (`price`, `quantity`, `productID`, `userID`) VALUES (?, ?, ?, ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setFloat(1, Float.parseFloat(cart.getPrice()));
            pstm.setInt(2, Integer.parseInt(cart.getQuantity()));
            pstm.setInt(3, Integer.parseInt(cart.getProductID()));// 
            pstm.setInt(4, Integer.parseInt(cart.getUserID()));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("AddCart: " + e);
        }
        return false;
    }

    public ArrayList<Cart> GetCartListByUserId(String userId) {
        ArrayList<Cart> data = new ArrayList<>();
        String sqlSelect = "SELECT * FROM swp.cart where userID=?;";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(userId));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String cartID = String.valueOf(rs.getInt(1));
                String title = String.valueOf(rs.getString(2));
                String price = String.valueOf(rs.getFloat(3));
                String quantity = String.valueOf(rs.getInt(4));
                String totalcost = String.valueOf(rs.getFloat(5));
                String productID = String.valueOf(rs.getInt(6));
                String userID = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                data.add(new Cart(cartID, title, price, quantity, totalcost, productID, userID, status));
            }
        } catch (Exception e) {
            System.out.println("GetCartListByUserId: " + e);
        }
        return data;
    }

    public static void main(String[] args) {
        CartDAO cartDAO = new CartDAO();
        ArrayList<Cart> data = cartDAO.GetCartListByUserId("1");
//        for (Cart cart : data) {
//            System.out.println(cart.getCartID());
//            System.out.println(cart.getPrice());
//            System.out.println(cart.getProductID());
//            System.out.println(cart.getQuantity());
//            System.out.println(cart.getStatus());
//            System.out.println(cart.getTitle());
//            System.out.println(cart.getTotalcost());
//            System.out.println(cart.getUserID());
//            System.out.println("");
//        }
    }
}
