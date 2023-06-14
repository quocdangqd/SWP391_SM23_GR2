/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Cart;

/**
 *
 * @author PC
 */
public class CartDAO extends ConnectMySQL {

    public boolean DeleteCartByID(String cartID) {
        try {
            String sqlSelect = "DELETE FROM `swp`.`cart` WHERE (`cartID` = ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(cartID));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("DeleteCartByID: " + e);
        }
        return false;
    }

    public boolean AddCart(Cart cart) {
        try {
            String sqlSelect = "INSERT INTO `swp`.`cart` (`price`, `quantity`, `productID`, `userID`) VALUES (?, ?, ?, ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setFloat(1, Float.parseFloat(cart.getPrice()));
            pstm.setInt(2, Integer.parseInt(cart.getQuantity()));
            pstm.setInt(3, Integer.parseInt(cart.getProductID()));// 
            pstm.setInt(4, Integer.parseInt(cart.getUserID()));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("AddCart: " + e);
        }
        return false;
    }

    public static void main(String[] args) {
        CartDAO cartDAO = new CartDAO();
        Cart cart = new Cart();

        cart.setPrice("2003");
        cart.setQuantity("10");
        cart.setProductID("1");
        cart.setUserID("1");
        cartDAO.AddCart(cart);
        cartDAO.DeleteCartByID("20");
//        System.out.println(cart.getPrice());
    }
}
