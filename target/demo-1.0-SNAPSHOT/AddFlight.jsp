<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 18.04.2022
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.entitys.Airport" %>
<%@ page import="java.util.List" %>
<% List<Airport> list=(ArrayList)session.getAttribute("All"); %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Добавить рейс</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>


</head>
<body>
<h1 class="title">Добавить рейс</h1>
<form action="/demo_war_exploded/AddFlightServlet" method="post">
    <div class="input">
        <label for="name">Название</label>
        <input type="text" name="name" id="name" required>
    </div>


    <div class="input">
        <label for="date">Дата</label>
        <input type="text" name="date" id="date" required>
    </div>
    <div class="input">
        <label for="time">Время</label>
        <input type="text" name="time" id="time" required>
    </div>
    <div class="input">
        <label class="airport">Выберете аэропорт: </label>
        <select name="airport_id" required>
            <option selected>Выберите аэропорт</option>
            <%for (Airport item :
                    list) {
                out.println("<option value=\""+item.getAirportId()+"\">"+item.getAirportId()+"</option>"
                );
            }%>
        </select>
    </div>


    <div class="button login">
        <button class="button" type="submit">Добавить</button>
        <button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AllFlightServlet';">Отмена</button>
    </div>


</form>

<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>

