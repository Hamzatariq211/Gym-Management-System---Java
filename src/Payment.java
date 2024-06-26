import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Payment {
    private String userId;
    private double amount;
    private String payDate;
    private String payMonth;
    private String description;

    public Payment(String userId, double amount, String payDate, String payMonth, String description) {
        this.userId = userId;
        this.amount = amount;
        this.payDate = payDate;
        this.payMonth = payMonth;
        this.description = description;

        addPaymentToDatabase();
    }

    private void addPaymentToDatabase() {
        try (Connection conn = DBConnection.getConnection()) {
            String insertQuery = "INSERT INTO Payments (UserID, Amount, PaymentDate, Paymonth, Description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, userId);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, payDate);
            pstmt.setString(4, payMonth);
            pstmt.setString(5, description);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log it, display an error message, etc.)
        }
    }
}
