package Model;

/**
 *
 * @author DucPhaoLo
 */
public class Cart {
    private String cartID,  title, price, quantity, totalcost, productID, userID, status;

    public Cart() {
    }

    public Cart(String cartID, String title, String price, String quantity, String totalcost, String productID, String userID, String status) {
        this.cartID = cartID;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.totalcost = totalcost;
        this.productID = productID;
        this.userID = userID;
        this.status = status;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
