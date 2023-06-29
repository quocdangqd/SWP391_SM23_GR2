/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.User;
import java.util.ArrayList;

/**
 *
 * @author trand
 */
public class UserDAO extends ConnectMySQL {
    
    public ArrayList<User> GetUserList() {
        ArrayList<User> data = new ArrayList<>();
        try {
            String sqlSelectString = "SELECT * FROM swp.user;";
            pstm = connection.prepareStatement(sqlSelectString);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getInt(1));
                String username = String.valueOf(rs.getString(2));
                String password = String.valueOf(rs.getString(3));
                String user_role = String.valueOf(rs.getInt(4));
                String name = String.valueOf(rs.getString(5));
                String age = String.valueOf(rs.getInt(6));
                String user_sexID = String.valueOf(rs.getInt(7));
                String address = String.valueOf(rs.getString(8));
                String phone = String.valueOf(rs.getString(9));
                String avata = String.valueOf(rs.getString(10));
                String register_code = String.valueOf(rs.getString(11));
                String email = String.valueOf(rs.getString(12));
                String status = String.valueOf(rs.getInt(13));
                data.add(new User(userID, username, password, user_role, name, age, user_sexID, address, phone, avata, register_code, email, status));
            }
        } catch (Exception e) {
            System.out.println("GetCategoriesesList: " + e);
        }
        return data;
    }
    
    public User getUserById(String ID) {
        try {
            String sqlSelectString = "select * from user where userID=?";
            pstm = connection.prepareStatement(sqlSelectString);
            pstm.setInt(1, Integer.parseInt(ID));
            rs = pstm.executeQuery();
            if(rs.next()){
                String userID = String.valueOf(rs.getInt(1));
                String username = String.valueOf(rs.getString(2));
                String password = String.valueOf(rs.getString(3));
                String user_role = String.valueOf(rs.getInt(4));
                String name = String.valueOf(rs.getString(5));
                String age = String.valueOf(rs.getInt(6));
                String user_sexID = String.valueOf(rs.getInt(7));
                String address = String.valueOf(rs.getString(8));
                String phone = String.valueOf(rs.getString(9));
                String avata = String.valueOf(rs.getString(10));
                String register_code = String.valueOf(rs.getString(11));
                String email = String.valueOf(rs.getString(12));
                String status = String.valueOf(rs.getInt(13));
                User data = new User(userID, username, password, user_role, name, age, user_sexID, address, phone, avata, register_code, email, status);
                return data;
            }
        } catch (Exception e) {
            System.out.println("GetCategoriesesList: " + e);
        }
        return null;
    }
}
