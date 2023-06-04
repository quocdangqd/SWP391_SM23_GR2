
package Dal;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectMySQL {

    private static String DB_URL = "jdbc:mysql://localhost:3306/swp";
    private static String USER_NAME = "root";
    private static String PASSWORD = "Sirducdz7a@";
    protected Connection connection = null;
    public ConnectMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connect Successfully!");
        } catch (Exception ex) {
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
    }
    
}
