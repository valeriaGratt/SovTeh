<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 24.05.2023
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
    <h3>Оценка студента</h3>
    <p></p>
    <p></p>
    <form action="students" method="GET">
        <label for="name">Имя:</label><p>
        <input id="name" type="text" name="name"><p>
        <label for="second_name">Отчество:</label><p>
        <input id="second_name" type="text" name="second_name"><p>
        <label for="last_name">Фамилия:</label><p>
        <input id="last_name" type="text" name="last_name"><p>
        <label for="subject">Предмет:</label><p>
        <input id="subject" type="text" name="subject"><p>
        <label for="result">Оценка:</label><p>
        <input id="result" type="text" name="result"><p>
        <input type="submit" value="Сохранить">
    </form>
</body>
</html>
