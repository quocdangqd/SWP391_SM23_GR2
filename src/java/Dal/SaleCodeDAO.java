package Dal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DucPhaoLo
 */
public class SaleCodeDAO extends ConnectMySQL {

    public float checkValidSaleCodeAndReturnSaleRate(String saleCode) {
        try {
            String sqlSelect = "SELECT * FROM swp.salecode where code =? and expiration_date >= ?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, saleCode);
            SimpleDateFormat sfDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            pstm.setDate(2, java.sql.Date.valueOf(sfDateFormat.format(date)));
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (rs.getInt(3) > 0) {
                    return rs.getFloat(5);
                }
            }
        } catch (Exception e) {
            System.out.println("checkValidSalceCode: " + saleCode);
        }
        return 0;
    }

    public static void main(String[] args) {
        SaleCodeDAO saleCodeDAO = new SaleCodeDAO();
        System.out.println(saleCodeDAO.checkValidSaleCodeAndReturnSaleRate("12bjbqbwe"));
    }
}
