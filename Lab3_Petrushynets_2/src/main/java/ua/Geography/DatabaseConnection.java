package ua.Geography;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    // URL бази даних PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/geography";

    // Логін та пароль користувача бази даних
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    // Метод для встановлення з'єднання
    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        return DriverManager.getConnection(URL, props);
    }
}