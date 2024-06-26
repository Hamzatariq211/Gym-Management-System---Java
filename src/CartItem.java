import java.math.BigDecimal;
import java.sql.*;

public class CartItem {
    private int itemId;
    private String itemName;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;

    // Constructor
    public CartItem() {
        // Default constructor
    }

    // Constructor with parameters
    public CartItem(int itemId, String itemName, int quantity, BigDecimal price, BigDecimal totalPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    // Getters and setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Method to insert an item into the cart table
    public void addToCart(Connection connection) {
        try {
            String insertQuery = "INSERT INTO Cart (item_id, item_name, quantity, price, total_price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, this.itemId);
            preparedStatement.setString(2, this.itemName);
            preparedStatement.setInt(3, this.quantity);
            preparedStatement.setBigDecimal(4, this.price);
            preparedStatement.setBigDecimal(5, this.totalPrice);
            preparedStatement.executeUpdate();
            System.out.println("Item added to the cart successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
