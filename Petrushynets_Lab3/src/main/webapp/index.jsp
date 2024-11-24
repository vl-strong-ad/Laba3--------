<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>SQL Query Executor</title>
</head>
<body>
    <h2>SQL-запити для таблиць Mainland, Country, City</h2>
    
    <!-- Форма для таблиці Street -->
    <h3>Mainland</h3>
    <form action="ExecuteQueryServlet" method="POST">
        <input type="hidden" name="table" value="mainland">
        <textarea name="query" rows="4" cols="50" placeholder="Наприклад: SELECT * FROM mainland;"></textarea><br><br>
        <input type="submit" value="Виконати запит">
    </form>

    <!-- Форма для таблиці Building -->
    <h3>Country</h3>
    <form action="ExecuteQueryServlet" method="POST">
        <input type="hidden" name="table" value="country">
        <textarea name="query" rows="4" cols="50" placeholder="Наприклад: SELECT * FROM country;"></textarea><br><br>
        <input type="submit" value="Виконати запит">
    </form>

    <!-- Форма для таблиці Apartment -->
    <h3>City</h3>
    <form action="ExecuteQueryServlet" method="POST">
        <input type="hidden" name="table" value="city">
        <textarea name="query" rows="4" cols="50" placeholder="Наприклад: SELECT * FROM city;"></textarea><br><br>
        <input type="submit" value="Виконати запит">
    </form>

    <!-- Вивід результатів -->
    <div id="results">
        <h3>Результат запиту:</h3>
        ${queryResult} <!-- Виведення результату виконання запиту -->
    </div>
</body>
</html>
