package ua.Geography;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Клас для управління підключенням до бази даних PostgreSQL.
 */
public class DatabaseConnection {

    // URL бази даних PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/geography";

    // Логін та пароль користувача бази даних
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    static {
        try {
            // Реєстрація драйвера PostgreSQL
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL Driver not found. Ensure it's in your classpath.", e);
        }
    }

    /**
     * Встановлює та повертає з'єднання з базою даних.
     *
     * @return Connection - з'єднання з базою даних
     * @throws SQLException якщо виникла помилка при підключенні
     */
    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);

        // Встановлення з'єднання
        return DriverManager.getConnection(URL, props);
    }

    /**
     * Правильно закриває з'єднання.
     *
     * @param connection з'єднання для закриття
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close database connection: " + e.getMessage());
            }
        }
    }
}
