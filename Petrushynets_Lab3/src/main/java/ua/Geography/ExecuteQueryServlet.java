package ua.Geography;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/ExecuteQueryServlet")
public class ExecuteQueryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Установка кодування для запиту та відповіді
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Отримання параметрів
        String query = request.getParameter("query");
        StringBuilder queryResult = new StringBuilder();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            // Перевірка: чи є запит SELECT або модифікацією даних
            boolean hasResultSet = stmt.execute(query);

            if (hasResultSet) {
                ResultSet rs = stmt.getResultSet();
                int columns = rs.getMetaData().getColumnCount();

                // Формуємо HTML-таблицю з результатами
                queryResult.append("<table border='1'>");
                queryResult.append("<tr>");
                for (int i = 1; i <= columns; i++) {
                    queryResult.append("<th>").append(rs.getMetaData().getColumnName(i)).append("</th>");
                }
                queryResult.append("</tr>");

                while (rs.next()) {
                    queryResult.append("<tr>");
                    for (int i = 1; i <= columns; i++) {
                        queryResult.append("<td>").append(rs.getString(i)).append("</td>");
                    }
                    queryResult.append("</tr>");
                }
                queryResult.append("</table>");
                rs.close(); // Закриваємо ResultSet після роботи
            } else {
                int updateCount = stmt.getUpdateCount();
                queryResult.append("<p>Запит виконано успішно. Змінено рядків: ").append(updateCount).append("</p>");
            }
        } catch (Exception e) {
            queryResult.append("<p style='color: red;'>Помилка виконання запиту: ").append(e.getMessage()).append("</p>");
        }

        // Передаємо результат у JSP
        request.setAttribute("queryResult", queryResult.toString());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
