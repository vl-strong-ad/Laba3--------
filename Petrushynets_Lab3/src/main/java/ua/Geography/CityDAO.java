package ua.Geography;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO {

    // Insert (Create)
    public void insertCity(int city_id, String city_name) {
        String sql = "INSERT INTO city (city_id, city_name) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, city_id);
            pstmt.setString(2, city_name);
            pstmt.executeUpdate();
            System.out.println("City inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllCities() {
        String sql = "SELECT city_id, city_name FROM city";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int city_id = rs.getInt("city_id");
                String city_name = rs.getString("city_name");
                System.out.println("City ID: " + city_id + ", City Name: " + city_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateCity(int city_id, String city_name) {
        String sql = "UPDATE city SET city_name = ? WHERE city_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, city_name);
            pstmt.setInt(2, city_id);
            pstmt.executeUpdate();
            System.out.println("City updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteCity(int city_id) {
        String sql = "DELETE FROM city WHERE city_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, city_id);
            pstmt.executeUpdate();
            System.out.println("City deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
