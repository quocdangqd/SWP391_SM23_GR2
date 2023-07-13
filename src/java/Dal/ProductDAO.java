package Dal;

import Model.Categories;
import Model.Earphone;
import Model.Products;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

/**
 *
 * @author DucPhaoLo
 */
public class ProductDAO extends ConnectMySQL {

    public ArrayList<Products> getProductListByCategoryIDAndSort(String categoryID, String sortOrder) {
        ArrayList<Products> data = new ArrayList<>();
        try {
            String sqlSelectString = "";
            if (categoryID == null || categoryID.isEmpty()) {
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

    public List<Products> searchProducts(String keyword) {

        List<Products> data = new ArrayList<>();
        try {
            String sqlSelect = "Select * from product where name like ?  ";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, "%" + keyword + "%");
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
                p.setDate(String.valueOf(rs.getDate(12)));
                p.setCategories(new CategoriesDAO().getCategoryById(categories));
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return data;
    }

    public Products getProductsByID(String id) {

        try {
            String sqlSelect = "Select * from product where ProductID=" + id;
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            if (rs.next()) {
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
                p.setDate(String.valueOf(rs.getDate(12)));
                p.setCategories(new CategoriesDAO().getCategoryById(categories));
                return p;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public void updateProduct(Products p) {
        try {
//            String sql = "UPDATE product\n"
//                    + "SET product_categoryID=?,name=?,desciption=?,picture=?,picture2=?,picture3=?,price=?,quantity=?,status=?\n"
//                    + "WHERE productID=?;";
            String sql = "UPDATE product\n"
                    + "SET product_categoryID=?,name=?,desciption=?,picture=?,picture2=?,picture3=?,price=?,quantity=?,status=?,date=?\n"
                    + "WHERE productID=?;";
            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, Integer.parseInt(p.getProduct_categoryID()));
            stm.setInt(1, Integer.parseInt("1"));
            stm.setString(2, p.getName());
            stm.setString(3, p.getDesciption());
            stm.setString(4, p.getPicture());
            stm.setString(5, p.getPicture2());
            stm.setString(6, p.getPicture3());
            stm.setFloat(7, Float.parseFloat(p.getPrice()));
            stm.setInt(8, Integer.parseInt(p.getQuantity()));
            stm.setBoolean(9, p.getStatus().equals("1"));
            stm.setInt(9, Integer.parseInt("1"));
            stm.setDate(10, Date.valueOf(p.getDate()));

            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewProduct(Products p) {
        try {
            String sql = "INSERT INTO swp.`product` "
                    + "(product_categoryID, name, desciption, picture, picture2, picture3, price, quantity, status,date) "
                    + "VALUES\n"
                    + " (?, ?, ?, ?, ?, \n"
                    + "?, ?, ?, ?, ?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(p.getProduct_categoryID()));
            stm.setString(2, p.getName());
            stm.setString(3, p.getDesciption());
            stm.setString(4, p.getPicture());
            stm.setString(5, p.getPicture2());
            stm.setString(6, p.getPicture3());
            stm.setFloat(7, Float.parseFloat(p.getPrice()));
            stm.setInt(8, Integer.parseInt(p.getQuantity()));
            stm.setBoolean(9, p.getStatus().equals("1"));
            Date date=Date.valueOf(p.getDate());
            stm.setDate(10,date);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addNewEarphone(Earphone e) {
        try {
            String sql = "INSERT INTO swp.`earphone` "
                    + "(`type`,frequency,`sensitive`,impedance,meterial,size,battery,connection_distance,wire_length) "
                    + "VALUES\n"
                    + " (?, ?, ?, ?, ?, \n"
                    + "?, ?, ?, ?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,e.getType());
            stm.setFloat(2, Float.parseFloat(e.getFrequency()));
            stm.setFloat(3, Float.parseFloat(e.getSensitive()));
            stm.setFloat(4, Float.parseFloat(e.getImpedance()));
            stm.setString(5,e.getMeterial());
            stm.setString(6,e.getSize());
            stm.setString(7,e.getBattery());
            stm.setString(8,e.getConnection_distance());
            stm.setString(9,e.getWire_length());
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Products p = new Products();
        
        Earphone e = new Earphone();
           e.setFrequency("1");
           e.setSensitive("4");
           e.setImpedance("10");
           productDAO.addNewEarphone(e);
//        p.setProductID("46");
//        Categories c = new Categories();
//        c.setCategoryID("1");
//        p.setProduct_categoryID("1");
//        p.setQuantity("2");
//        p.setPrice("1");
//        p.setStatus("1");
//        p.setDate("2023-07-11");
//        productDAO.addNewProduct(p);

//        for(Products p  :productDAO.searchProducts("1")){
//           
//            p.setDate("");
//            
//        }
        //         System.out.println(productDAO.getProductsByID("1").getName());
//            
//        for (Products p : productDAO.getProductListByCategoryIDAndSort("", "descendingSalePrice")) {
//            System.out.println("productid: " + p.getProductID() + " ");
//            System.out.println("categoriID: " + p.getProduct_categoryID()+ " ");
//            System.out.println("Name: " + p.getName() + " ");
//            System.out.println("Description: " + p.getDesciption()+ " ");
//            System.out.println("picture: " + p.getPicture()+ " ");
//            System.out.println("picture2: " + p.getPicture2()+ " ");
//            System.out.println("picture3: " + p.getPicture3()+ " ");
//            System.out.println("price: " + p.getPrice() + " ");
//            System.out.println("quantity: " + p.getQuantity()+ " ");
//            System.out.println("status: " + p.getStatus()+ " ");
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
    }
}
