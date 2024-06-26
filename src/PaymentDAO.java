import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    static String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
    static String DB_USER = "root";
    static String DB_PASSWORD = "hamzasql12344321";

    private PaymentDAO() {
        // Private constructor to prevent direct instantiation
    }

    public static List<SinglePayment> getAllPayments() {
        List<SinglePayment> payments = new ArrayList<>();
        String query = "SELECT * FROM Payments";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int paymentID = resultSet.getInt("PaymentID");
                int userID = resultSet.getInt("UserID");
                double amount = resultSet.getDouble("Amount");
                Date paymentDate = resultSet.getDate("PaymentDate");
                String paymonth = resultSet.getString("Paymonth");
                String description = resultSet.getString("Description");

                SinglePayment singlePayment = new SinglePayment(paymentID, userID, amount, paymentDate, paymonth, description);
                payments.add(singlePayment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
