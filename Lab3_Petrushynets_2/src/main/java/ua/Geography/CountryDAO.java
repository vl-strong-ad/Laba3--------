package ua.Geography;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAO {

    // Insert (Create)
    public void insertCountry(int country_id, char country_name, int population) {
        String sql = "INSERT INTO country (country_id, country_name, population) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, country_id);
            pstmt.setString(2, String.valueOf(country_name)); // Преобразуем char в строку
            pstmt.setInt(3, population);
            pstmt.executeUpdate();
            System.out.println("Country inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllCountries() {
        String sql = "SELECT country_id, country_name, population FROM country";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int country_id = rs.getInt("country_id");
                char country_name = rs.getString("country_name").charAt(0); // Извлекаем первый символ строки
                int population = rs.getInt("population");
                System.out.println("Country ID: " + country_id + ", Country Name: " + country_name + ", Population: " + population);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateCountry(int country_id, char country_name, int population) {
        String sql = "UPDATE country SET country_name = ?, population = ? WHERE country_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, String.valueOf(country_name)); // Преобразуем char в строку
            pstmt.setInt(2, population);
            pstmt.setInt(3, country_id);
            pstmt.executeUpdate();
            System.out.println("Country updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteCountry(int country_id) {
        String sql = "DELETE FROM country WHERE country_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, country_id);
            pstmt.executeUpdate();
            System.out.println("Country deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
