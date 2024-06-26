import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnectionWorkoutAdd {
    private static DatabaseConnectionWorkoutAdd instance;
    private Connection connection;

    private DatabaseConnectionWorkoutAdd() {
        String JDBC_URL = "jdbc:mysql://localhost:3306/PulseFusion";
        String DB_USER = "root";
        String DB_PASSWORD = "hamzasql12344321";
        try {
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseConnectionWorkoutAdd getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionWorkoutAdd();
        }
        return instance;
    }

    public void addWorkoutPlan(int userID, WorkoutPlan workoutPlan) {
        String sql = "SELECT * FROM workout_plan WHERE user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // If data exists for the user, perform an update
            if (resultSet.next()) {
                sql = "UPDATE workout_plan SET monday=?, tuesday=?, wednesday=?, thursday=?, friday=?, saturday=?, sunday=? WHERE user_id=?";
                try (PreparedStatement updateStatement = connection.prepareStatement(sql)) {
                    updateStatement.setString(1, workoutPlan.getMonday());
                    updateStatement.setString(2, workoutPlan.getTuesday());
                    updateStatement.setString(3, workoutPlan.getWednesday());
                    updateStatement.setString(4, workoutPlan.getThursday());
                    updateStatement.setString(5, workoutPlan.getFriday());
                    updateStatement.setString(6, workoutPlan.getSaturday());
                    updateStatement.setString(7, workoutPlan.getSunday());
                    updateStatement.setInt(8, userID);

                    int rowsUpdated = updateStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Workout plan updated successfully.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                // If no data exists for the user, perform an insert
                sql = "INSERT INTO workout_plan (user_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement insertStatement = connection.prepareStatement(sql)) {
                    insertStatement.setInt(1, userID);
                    insertStatement.setString(2, workoutPlan.getMonday());
                    insertStatement.setString(3, workoutPlan.getTuesday());
                    insertStatement.setString(4, workoutPlan.getWednesday());
                    insertStatement.setString(5, workoutPlan.getThursday());
                    insertStatement.setString(6, workoutPlan.getFriday());
                    insertStatement.setString(7, workoutPlan.getSaturday());
                    insertStatement.setString(8, workoutPlan.getSunday());

                    int rowsInserted = insertStatement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Workout plan inserted successfully.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Other database methods

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
