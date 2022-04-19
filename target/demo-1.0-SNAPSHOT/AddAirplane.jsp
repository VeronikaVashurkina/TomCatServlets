<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 18.04.2022
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.entitys.Flight" %>
<%@ page import="java.util.List" %>
<% List<Flight> list=(ArrayList)session.getAttribute("All"); %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Добавить самолет</title>
    <!-- <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
     <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
     <link rel="stylesheet" href="css/normalize.css"/>
     <link rel="stylesheet" href="css/style.css"/>
     -->
</head>
<body>
<h1>Добавить самолет</h1>
<form action="/demo_war_exploded/AddAirplaneServlet" method="post">
    <div class="input">
        <label for="model">Модель</label>
        <input type="text" name="model" id="model" required>
    </div>

    <div class="input">
        <label for="kg">Вместительность</label>
        <input type="number" name="kg" id="kg" required>
    </div>
    <label class="flight">Выберете рейс: </label>
    <select name="flight_id" required>
        <option selected>Выберите рейс</option>
        <%for (Flight item :
                list) {
            out.println("<option value=\""+item.getFlightId()+"\">"+item.getFlightId()+"</option>"
            );
        }%>
    </select>



<div class="button login">
    <button style="width: 50%" type="submit">Добавить</button>
    <button style="width: 50%" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/hello-servlet';">Отмена</button>
</div>


</form>

<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>

