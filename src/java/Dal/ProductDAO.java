package Dal;

import java.text.NumberFormat;
import java.util.Locale;
import Model.Categories;
import Model.Products;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author DucPhaoLo
 */
public class ProductDAO extends ConnectMySQL {

    public ArrayList<Products> getProductListByCategoryIDAndNameAndSort(String categoryID, String Name, String sortOrder) {
        ArrayList<Products> data = new ArrayList<>();
        try {
            String sqlSelectString = "";
            if (categoryID == null || categoryID.isEmpty()) {
                if (sortOrder.equals("rate")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.name like '%" + Name + "%' \n"
                            + "group by productid order by rate desc";
                } else if (sortOrder.equals("ascendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice asc";
                } else if (sortOrder.equals("descendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice desc";
                }
            } else {
                if (sortOrder.equals("rate")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=? and p.name like '%" + Name + "%'\n"
                            + "group by productid order by rate desc ";
                } else if (sortOrder.equals("ascendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=? and p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice asc ";
                } else if (sortOrder.equals("descendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=? and p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice desc ";
                }
            }
//            DecimalFormat decimalFormat = new DecimalFormat("#");
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
//            String formattedNumber = decimalFormat.format(number);
            pstm = connection.prepareStatement(sqlSelectString);
            if (categoryID != null && !categoryID.isEmpty()) {
                pstm.setInt(1, Integer.parseInt(categoryID));
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getInt(1));
                String product_categoryID = String.valueOf(rs.getInt(2));
                String name = String.valueOf(rs.getString(3));
                String desciption = String.valueOf(rs.getString(4));
                String picture = String.valueOf(rs.getString(5));
                String price = String.valueOf(decimalFormat.format((int) rs.getFloat(6)));
                String quantity = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                String sale = String.valueOf(decimalFormat.format((int) rs.getFloat(9)));
                String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                    rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                }
                String salePrice = String.valueOf(decimalFormat.format((int) rs.getDouble(11)));
                salePrice = salePrice.replaceAll(",", ".");
                String picture2 = String.valueOf(rs.getString(12));
                String picture3 = String.valueOf(rs.getString(13));
                data.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rateStar, salePrice, picture2, picture3));
            }
        } catch (Exception e) {
            System.out.println("getProductListByCategoryIDAndNameAndSort: " + e);
        }
        return data;
    }

    public ArrayList<Products> BestSellerProducts() {
        ArrayList<Products> data = new ArrayList<>();

        CategoriesDAO categoriesDAO = new CategoriesDAO();
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
        decimalFormat.applyPattern("#,###");
        ArrayList<Categories> categoryIdList = categoriesDAO.GetCategoriesList();
        try {
            for (Categories c : categoryIdList) {
                ArrayList<String> productidList = new ArrayList<>();
                // find most rate productId
                String sqlSelect = "select p.productid,coalesce(sum(product_rate)/count(product_rate),0) 'rate'  \n"
                        + "from swp.orderdetail od right outer join swp.product p\n"
                        + "on p.ProductID=od.orderdetail_productID where product_categoryID=?\n"
                        + "group by p.productid\n"
                        + "order by rate desc\n"
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
                        String price = String.valueOf(decimalFormat.format((int) rs.getFloat(6)));
                        String quantity = String.valueOf(rs.getInt(7));
                        String status = String.valueOf(rs.getInt(8));
                        String sale = String.valueOf(decimalFormat.format((int) rs.getFloat(9)));
                        String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                        if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                            rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                        }
                        String salePrice = String.valueOf(decimalFormat.format((int) rs.getDouble(11)));
                        salePrice = salePrice.replaceAll(",", ".");
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

    public ArrayList<Products> getProductListByType(String type) {
        ArrayList<Products> data = new ArrayList<>();
        try {
            String sqlSelectString;
            if (type.equals("HighPrice")) {
                sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                        + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                        + "from swp.earphone e, swp.orderdetail od right outer join swp.product p \n"
                        + "on p.ProductID=od.orderdetail_productID  where e.earphone_ProductID=p.ProductID and COALESCE(p.price-p.price*p.sale/100,p.price) >'1000000'\n"
                        + "group by productid ,e.type\n"
                        + "order by rate desc;";
            } else {
                sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                        + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                        + "from swp.earphone e, swp.orderdetail od right outer join swp.product p \n"
                        + "on p.ProductID=od.orderdetail_productID  where e.earphone_ProductID=p.ProductID and e.type=?\n"
                        + "group by productid ,e.type\n"
                        + "order by rate desc;";
            }
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            pstm = connection.prepareStatement(sqlSelectString);
            if (!type.equals("HighPrice")) {
                pstm.setString(1, type);
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getInt(1));
                String product_categoryID = String.valueOf(rs.getInt(2));
                String name = String.valueOf(rs.getString(3));
                String desciption = String.valueOf(rs.getString(4));
                String picture = String.valueOf(rs.getString(5));
                String price = String.valueOf(decimalFormat.format((int) rs.getFloat(6)));
                String quantity = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                String sale = String.valueOf(decimalFormat.format((int) rs.getFloat(9)));
                String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                    rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                }
                String salePrice = String.valueOf(decimalFormat.format((int) rs.getDouble(11)));
                salePrice = salePrice.replaceAll(",", ".");
                String picture2 = String.valueOf(rs.getString(12));
                String picture3 = String.valueOf(rs.getString(13));
                data.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rateStar, salePrice, picture2, picture3));
            }
        } catch (Exception e) {
            System.out.println("getProductListByType: " + e);
        }
        return data;
    }

    // Duc Anh
    public int CountProduct() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM product";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public int CountSaler() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM user\n"
                + "where user_roleID = '4'";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public int CountProductLow() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM swp.product\n"
                + "where quantity = '0';";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public ArrayList<Products> limitProducts() {
        ArrayList<Products> data = new ArrayList<>();
        try {
            String sqlSelect = "Select * from product\n"
                    + "where quantity = 0";
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setProductID(String.valueOf(rs.getInt(1)));
                String categories = String.valueOf(rs.getInt(2));
                p.setProduct_categoryID(categories);
                p.setName(String.valueOf(rs.getString(3)));
                p.setDesciption(String.valueOf(rs.getString(4)));
                p.setPicture(rs.getString(5));
                p.setPicture2(rs.getString(6));
                p.setPicture3(rs.getString(7));
                p.setPrice(String.valueOf(rs.getFloat(8)));
                p.setQuantity(String.valueOf(rs.getInt(9)));
                p.setStatus(String.valueOf(rs.getInt(10)));
                p.setCategories(new CategoriesDAO().getCategoryById(categories));
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
    // Duc Anh 
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        System.out.println(productDAO.getProductListByType("HighPrice").size());
        ArrayList list = new ArrayList();
        list = productDAO.limitProducts();
        System.out.println(list);
        // Định dạng số với dấu chấm
//        int size = productDAO.getProductListByCategoryIDAndNameAndSort("1","a","ascendingSalePrice").size();
//        size = productDAO.BestSellerProducts().size();
//        size=productDAO.getProductListByCategoryIDAndSort("1", "rate").size();
//        System.out.println(size);
//        System.out.println(formattedNumber);
//        for (Products p : productDAO.getProductListByCategoryIDAndNameAndSort("1", "a", "rate")) {
//            System.out.println("productid: " + p.getProductID() + " ");
//            System.out.println("categoriID: " + p.getProduct_categoryID() + " ");
//            System.out.println("Name: " + p.getName() + " ");
//            System.out.println("Description: " + p.getDesciption() + " ");
//            System.out.println("picture: " + p.getPicture() + " ");
//            System.out.println("picture2: " + p.getPicture2() + " ");
//            System.out.println("picture3: " + p.getPicture3() + " ");
//            System.out.println("price: " + p.getPrice() + " ");
//            System.out.println("quantity: " + p.getQuantity() + " ");
//            System.out.println("status: " + p.getStatus() + " ");
//            System.out.println("sale: " + p.getSale() + " ");
//            System.out.println("rateStar: " + p.getRateStar() + " ");
//            System.out.println("saleprice: " + p.getSalePrice() + " ");
//            System.out.println("");
//        }

//        for (Products p : productDAO.BestSellerProducts()) {
//            System.out.print("productid: " + p.getProductID() + " ");
//            System.out.print("productName: " + p.getName() + " ");
//            System.out.print("price: " + p.getPrice() + " ");
//            System.out.print("sale: " + p.getSale() + " ");
//            System.out.print("rateStar: " + p.getRateStar() + " ");
//            System.out.print("saleprice: " + p.getSalePrice() + " ");
//            System.out.println("");
//        }
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
//        decimalFormat.applyPattern("#,###");
//        double x = 3.44;
//        System.out.println(new DecimalFormat("#.0").format(x));
//        for (Products p : productDAO.getProductListByType("wired")) {
//            System.out.println("productid: " + p.getProductID() + " ");
//            System.out.println("categoriID: " + p.getProduct_categoryID() + " ");
//            System.out.println("Name: " + p.getName() + " ");
//            System.out.println("Description: " + p.getDesciption() + " ");
//            System.out.println("picture: " + p.getPicture() + " ");
//            System.out.println("picture2: " + p.getPicture2() + " ");
//            System.out.println("picture3: " + p.getPicture3() + " ");
//            System.out.println("price: " + p.getPrice() + " ");
//            System.out.println("quantity: " + p.getQuantity() + " ");
//            System.out.println("status: " + p.getStatus() + " ");
//            System.out.println("sale: " + p.getSale() + " ");
//            System.out.println("rateStar: " + p.getRateStar() + " ");
//            System.out.println("saleprice: " + p.getSalePrice() + " ");
//            System.out.println("");
//        }
    }
}
