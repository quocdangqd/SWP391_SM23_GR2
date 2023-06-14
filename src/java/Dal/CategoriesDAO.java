package Dal;

import Model.Categories;
import java.util.ArrayList;

/**
 *
 * @author DucPhaoLo
 */
public class CategoriesDAO extends ConnectMySQL {

    public ArrayList<Categories> GetCategoriesList() {
        ArrayList<Categories> data = new ArrayList<>();
        try {
            String sqlSelectString = "SELECT * FROM swp.category;";
            pstm = connection.prepareStatement(sqlSelectString);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String categoryID = String.valueOf(rs.getInt(1));
                String name = String.valueOf(rs.getString(2));
                String status = String.valueOf(rs.getInt(3));
                data.add(new Categories(categoryID, name, status));
            }
        } catch (Exception e) {
            System.out.println("GetCategoriesesList: " + e);
        }
        return data;
    }

    public static void main(String[] args) {
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        for (Categories c : categoriesDAO.GetCategoriesList()) {
            System.out.println(c.getCategoryID());
        }
    }
}
