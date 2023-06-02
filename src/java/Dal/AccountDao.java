/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class AccountDao extends ConnectMySQL {

    PreparedStatement pstm;// thuc thi sql
    ResultSet rs;// luu tru va xu li du lieu

    public boolean checkExistAccount(String userName) {
        try {
            String sqlSelect = "SELECT * FROM swp.user where username=?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, userName);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkExistAccount: " + e);
        }
        return false;
    }

    public boolean AddUser(User user) {
        try {
            String sqlSelect = "insert into swp.user(userID, username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            user.setUserID(String.valueOf(GetUserIndex()));
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(user.getUserID()));
            pstm.setString(2, user.getUsername());
            pstm.setString(3, user.getPassword());
            pstm.setInt(4, Integer.parseInt(user.getUser_roleID()));
            pstm.setString(5, user.getName());
            pstm.setInt(6, Integer.parseInt(user.getAge()));// fix in model
            pstm.setInt(7, Integer.parseInt(user.getUser_sexID()));
            pstm.setString(8, user.getAddress());
            pstm.setString(9, user.getPhone_number());
            pstm.setString(10, user.getAvatar());
            pstm.setString(11, user.getRegister_code());
            pstm.setString(12, user.getEmail());
            pstm.setInt(13, Integer.parseInt(user.getStatus()));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("AddUser: " + e);
        }
        return false;
    }

    public int GetUserIndex() {
        String sqlSelect = "select max(userID)  FROM swp.user;";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            if (rs.next() == false) {
                return 1;
            } else {
                return Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("GetUserIndex: " + e);
        }
        return -1;
    }

    public static void main(String[] args) {
        AccountDao dao = new AccountDao();
//        System.out.println(dao.checkExistAccount("admin1"));
        User user= new User();
        user.userID="11";
        user.username="adminn";
        user.password="123";
        user.user_roleID="1";
        user.name="DucNguyen";
        user.age ="13";
        user.user_sexID ="1";
        user.address ="thanhxa";
        user.phone_number ="thanhxa";
        user.avatar ="1";
        user.register_code ="123";
        user.email ="ducnvhe160331@gmail.com";
        user.status ="2";
        dao.AddUser(user);
    }
}
