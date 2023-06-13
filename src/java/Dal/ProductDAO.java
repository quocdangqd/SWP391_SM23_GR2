package Dal;

import Model.Categories;
import Model.Products;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

/**
 *
 * @author PC
 */
public class ProductDAO extends ConnectMySQL {

    public ArrayList<Products> getProductListByCategoryIDAndSort(String categoryID, String sortOrder) {
        ArrayList<Products> data = new ArrayList<>();
        try {
            String sqlSelectString = "";
            if (categoryID == null) {
                if (sortOrder == "rate") {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID \n"
                            + "group by productid order by rate desc";
                } else if (sortOrder == "ascendingSalePrice") {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID \n"
                            + "group by productid order by SalePrice asc";
                } else if (sortOrder == "descendingSalePrice") {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID \n"
                            + "group by productid order by SalePrice desc";
                }
            } else {
                if (sortOrder == "rate") {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=?\n"
                            + "group by productid order by rate desc ";
                } else if (sortOrder == "ascendingSalePrice") {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=?\n"
                            + "group by productid order by SalePrice asc ";
                } else if (sortOrder == "descendingSalePrice") {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=?\n"
                            + "group by productid order by SalePrice desc ";
                }
            }
            DecimalFormat decimalFormat = new DecimalFormat("#");
            pstm = connection.prepareStatement(sqlSelectString);
            if (categoryID != null) {
                pstm.setInt(1, Integer.parseInt(categoryID));
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getInt(1));
                String product_categoryID = String.valueOf(rs.getInt(2));
                String name = String.valueOf(rs.getString(3));
                String desciption = String.valueOf(rs.getString(4));
                String picture = String.valueOf(rs.getString(5));
                String price = String.valueOf(decimalFormat.format(rs.getFloat(6)));
                String quantity = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                String sale = String.valueOf(decimalFormat.format(rs.getFloat(9)));
                String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                    rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                }
                String salePrice = String.valueOf(decimalFormat.format(rs.getDouble(11)));
                String picture2 = String.valueOf(rs.getString(12));
                String picture3 = String.valueOf(rs.getString(13));
                data.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rateStar, salePrice, picture2, picture3));
            }
        } catch (Exception e) {
            System.out.println("getProductListByCategoryID: " + e);
        }
        return data;
    }

    public ArrayList<Products> BestSellerProducts() {
        ArrayList<Products> data = new ArrayList<>();

        CategoriesDAO categoriesDAO = new CategoriesDAO();
        DecimalFormat decimalFormat = new DecimalFormat("#");
        ArrayList<Categories> categoryIdList = categoriesDAO.GetCategoriesList();
        try {
            for (Categories c : categoryIdList) {
                ArrayList<String> productidList = new ArrayList<>();
                // find most rate productId
                String sqlSelect = "select p.productid \n"
                        + "from swp.orderdetail od right outer join swp.product p\n"
                        + "on p.ProductID=od.orderdetail_productID where product_categoryID=?\n"
                        + "group by p.productid\n"
                        + "order by sum(product_rate) desc\n"
                        + "limit 2; ";
                pstm = connection.prepareStatement(sqlSelect);
                pstm.setInt(1, Integer.parseInt(c.getCategoryID()));
                rs = pstm.executeQuery();
                while (rs.next()) {
                    String orderdetail_productid = String.valueOf(rs.getInt(1));
                    productidList.add(orderdetail_productid);
                }
                // maxrate productdetail
                int count = 0;
                while (count < productidList.size()) {
                    String sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.ProductID=? -- where product_categoryID='1'\n"
                            + "group by productid ";
                    pstm = connection.prepareStatement(sqlSelectString);
                    pstm.setInt(1, Integer.parseInt(productidList.get(count)));
                    rs = pstm.executeQuery();
                    while (rs.next()) {
                        String ProductID = String.valueOf(rs.getInt(1));
                        String product_categoryID = String.valueOf(rs.getInt(2));
                        String name = String.valueOf(rs.getString(3));
                        String desciption = String.valueOf(rs.getString(4));
                        String picture = String.valueOf(rs.getString(5));
                        String price = String.valueOf(decimalFormat.format(rs.getFloat(6)));
                        String quantity = String.valueOf(rs.getInt(7));
                        String status = String.valueOf(rs.getInt(8));
                        String sale = String.valueOf(decimalFormat.format(rs.getFloat(9)));
                        String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                        if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                            rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                        }
                        String salePrice = String.valueOf(decimalFormat.format(rs.getDouble(11)));
                        String picture2 = String.valueOf(rs.getString(12));
                        String picture3 = String.valueOf(rs.getString(13));
                        data.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rateStar, salePrice, picture2, picture3));
                    }
                    ++count;
                }
            }
        } catch (Exception e) {
            System.out.println("BestSellerProductsByCategoryID: " + e);
        }
        return data;
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        for (Products p : productDAO.getProductListByCategoryIDAndSort("1", "rate")) {
            System.out.print("productid: " + p.getProductID() + " ");
            System.out.print("productName: " + p.getName() + " ");
            System.out.print("price: " + p.getPrice() + " ");
            System.out.print("sale: " + p.getSale() + " ");
            System.out.print("rateStar: " + p.getRateStar() + " ");
            System.out.print("saleprice: " + p.getSalePrice() + " ");
            System.out.println("");
        }

//        for (Products p : productDAO.BestSellerProducts()) {
//            System.out.print("productid: " + p.getProductID() + " ");
//            System.out.print("productName: " + p.getName() + " ");
//            System.out.print("price: " + p.getPrice() + " ");
//            System.out.print("sale: " + p.getSale() + " ");
//            System.out.print("rateStar: " + p.getRateStar() + " ");
//            System.out.print("saleprice: " + p.getSalePrice() + " ");
//            System.out.println("");
//        }
    }
}
