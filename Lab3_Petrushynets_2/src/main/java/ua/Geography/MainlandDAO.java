package ua.Geography;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainlandDAO {

    // Insert (Create)
    public void insertMainland(int mainland_id, char mainland_name) {
        String sql = "INSERT INTO mainland (mainland_id, mainland_name) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, mainland_id);
            pstmt.setString(2, String.valueOf(mainland_name)); // Преобразуем char в строку
            pstmt.executeUpdate();
            System.out.println("Mainland inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllMainlands() {
        String sql = "SELECT mainland_id, mainland_name FROM mainland";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int mainland_id = rs.getInt("mainland_id");
                char mainland_name = rs.getString("mainland_name").charAt(0); // Извлекаем первый символ строки
                System.out.println("Mainland ID: " + mainland_id + ", Mainland Name: " + mainland_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateMainland(int mainland_id, char mainland_name) {
        String sql = "UPDATE mainland SET mainland_name = ? WHERE mainland_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, String.valueOf(mainland_name)); // Преобразуем char в строку
            pstmt.setInt(2, mainland_id);
            pstmt.executeUpdate();
            System.out.println("Mainland updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteMainland(int mainland_id) {
        String sql = "DELETE FROM mainland WHERE mainland_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, mainland_id);
            pstmt.executeUpdate();
            System.out.println("Mainland deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
