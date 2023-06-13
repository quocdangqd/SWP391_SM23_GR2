/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

/**
 *
 * @author PC
 */
public class CartDAO extends ConnectMySQL {

    public boolean DeleteCartByID(String cartID) {
        try {
            String sqlSelect = "DELETE FROM `swp`.`cart` WHERE (`cartID` = ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, cartID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("DeleteCartByID: " + e);
        }
        return false;
    }
//    public boolean AddCart(Q user) {
//        try {
//            String sqlSelect = "insert into swp.user( username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
////            user.setUserID(String.valueOf(GetUserIndex()));
//            pstm = connection.prepareStatement(sqlSelect);
////            pstm.setInt(1, Integer.parseInt(user.getUserID()));
//            pstm.setString(1, user.getUsername());
//            pstm.setString(2, user.getPassword());
//            pstm.setInt(3, Integer.parseInt(user.getUser_roleID()));
//            pstm.setString(4, user.getName());
//            pstm.setInt(5, Integer.parseInt(user.getAge()));// fix in model
//            pstm.setInt(6, Integer.parseInt(user.getUser_sexID()));
//            pstm.setString(7, user.getAddress());
//            pstm.setString(8, user.getPhone_number());
//            pstm.setString(9, user.getAvatar());
//            pstm.setString(10, user.getRegister_code());
//            pstm.setString(11, user.getEmail());
//            pstm.setInt(12, Integer.parseInt(user.getStatus()));
//            pstm.execute();
//            return true;
//        } catch (Exception e) {
//            System.out.println("AddUser: " + e);
//        }
//        return false;
//    }
}
