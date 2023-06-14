package Dal;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DucPhaoLo
 */
public class AccountDao extends ConnectMySQL {

    public boolean checkExistEmail(String email) {
        try {
            String sqlSelect = "SELECT * FROM swp.user where email=?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkExistEmail: " + e);
        }
        return false;
    }

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

    public boolean checkExistAccountByEmail(String email) {
        try {
            String sqlSelect = "SELECT * FROM swp.user where email=?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkExistAccountByEmail: " + e);
        }
        return false;
    }

    public boolean AddUser(User user) {
        try {
            String sqlSelect = "insert into swp.user( username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            user.setUserID(String.valueOf(GetUserIndex()));
            pstm = connection.prepareStatement(sqlSelect);
//            pstm.setInt(1, Integer.parseInt(user.getUserID()));
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setInt(3, Integer.parseInt(user.getUser_roleID()));
            pstm.setString(4, user.getName());
            pstm.setInt(5, Integer.parseInt(user.getAge()));// fix in model
            pstm.setInt(6, Integer.parseInt(user.getUser_sexID()));
            pstm.setString(7, user.getAddress());
            pstm.setString(8, user.getPhone_number());
            pstm.setString(9, user.getAvatar());
            pstm.setString(10, user.getRegister_code());
            pstm.setString(11, user.getEmail());
            pstm.setInt(12, Integer.parseInt(user.getStatus()));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("AddUser: " + e);
        }
        return false;
    }

//    public int GetUserIndex() {
//        String sqlSelect = "select max(userID)  FROM swp.user;";
//        try {
//            pstm = connection.prepareStatement(sqlSelect);
//            rs = pstm.executeQuery();
//            if (rs.next() == false) {
//                return 1;
//            } else {
//                return Integer.parseInt(rs.getString(1));
//            }
//        } catch (Exception e) {
//            System.out.println("GetUserIndex: " + e);
//        }
//        return -1;
//    }
    public User GetUserByEmail(String email) {
        String sqlSelect = "select* from swp.user where email= ?";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getInt(1));
                String username = String.valueOf(rs.getString(2));
                String password = String.valueOf(rs.getString(3));
                String user_roleID = String.valueOf(rs.getInt(4));
                String name = String.valueOf(rs.getString(5));
                String age = String.valueOf(rs.getInt(6));
                String user_sexID = String.valueOf(rs.getInt(7));
                String address = String.valueOf(rs.getString(8));
                String phone_number = String.valueOf(rs.getString(9));
                String avatar = String.valueOf(rs.getString(10));
                String register_code = String.valueOf(rs.getString(11));
                String status = String.valueOf(rs.getInt(13));
                User user = new User(userID, username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status);
                return user;
            }
        } catch (Exception e) {
            System.out.println("GetUserByEmail: " + e);
        }
        return null;
    }

    public boolean resetPassword(String email, String newPassword) {
        try {
            String sqlSelect = "UPDATE `swp`.`user` SET `password` = ? WHERE (`email` = ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, newPassword);
            pstm.setString(2, email);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("resetPassword: " + e);
        }
        return false;
    }

//    public boolean updateUser(String password, String address) {
//        try {
//            String sqlSelect = "UPDATE `swp`.`user` SET `password` = ? WHERE (`email` = ?);";
//            pstm = connection.prepareStatement(sqlSelect);
//            pstm.setString(1, newPassword);
//            pstm.setString(2, email);
//            pstm.execute();
//            return true;
//        } catch (Exception e) {
//            System.out.println("resetPassword: " + e);
//        }
//        return false;
//    }
    public boolean checkLogin(User user) {
        try {
            String sqlString = "SELECT * FROM swp.user where username=? and password=?";
            pstm = connection.prepareStatement(sqlString);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkLogin: " + e);
        }
        return false;
    }

    public static void main(String[] args) {
        AccountDao dao = new AccountDao();
//        User u=dao.getUserByUserName("sirducdz");
//        System.out.println(u.getEmail());
//        System.out.println(dao.checkExistAccount("admin1"));
//        User u =dao.GetUserByEmail("ducnvhe160331@fpt.edu.vn");
//        System.out.println(u.getName());
//          User u = new User();
//          u.setUsername("sirducdz2");
//          u.setPassword("Sirducdzzzz2@");
//          System.out.println("dao.checkLogin(u)"+dao.checkLogin(u));
    }

    public User getUserByUserName(String userName) {
        String sqlSelect = "select* from swp.user where username= ?";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, userName);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getInt(1));
                String username = String.valueOf(rs.getString(2));
                String password = String.valueOf(rs.getString(3));
                String user_roleID = String.valueOf(rs.getInt(4));
                String name = String.valueOf(rs.getString(5));
                String age = String.valueOf(rs.getInt(6));
                String user_sexID = String.valueOf(rs.getInt(7));
                String address = String.valueOf(rs.getString(8));
                String phone_number = String.valueOf(rs.getString(9));
                String avatar = String.valueOf(rs.getString(10));
                String register_code = String.valueOf(rs.getString(11));
                String email = String.valueOf(rs.getString(12));
                String status = String.valueOf(rs.getInt(13));
                User user = new User(userID, username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status);
                return user;
            }
        } catch (Exception e) {
            System.out.println("getUserByUserName: " + e);
        }
        return null;
    }
}
