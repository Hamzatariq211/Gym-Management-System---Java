import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerFactory {
    private static TrainerFactory instance;

    private TrainerFactory() {
        // Private constructor to prevent instantiation
    }

    public static synchronized TrainerFactory getInstance() {
        if (instance == null) {
            instance = new TrainerFactory();
        }
        return instance;
    }

    public Trainer createTrainer(int trainerId, String username, String password, String name, String specialization, String experience) {
        return new Trainer(trainerId, username, password, name, specialization, experience);
    }
    
    
    private Connection getConnection() throws SQLException {
    	String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
        String DB_USER = "root";
        String DB_PASSWORD = "hamzasql12344321";
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
    }

    public Trainer getTrainerByUsername(String username) {
        Trainer trainer = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT * FROM trainers WHERE username = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int trainerId = resultSet.getInt("trainer_id");
                String fetchedUsername = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                String experience = resultSet.getString("experience");

                trainer = createTrainer(trainerId, fetchedUsername, password, name, specialization, experience);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trainer;
    }
    
    
    
    
    
    
    
    
    
    
    
}
