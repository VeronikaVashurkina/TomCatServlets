<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 19.04.2022
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="database.entitys.Airport" %>
<% List<Airport> listAir=(ArrayList)session.getAttribute("One"); %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Изменить аэропорт</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1 class="title">Изменить аэропорт</h1>
<form action="/demo_war_exploded/UpdateAirportServlet?id=<%out.println(listAir.get(0).getAirportId());%>" method="post">
    <div class="input">
        <label for="name">Название</label>
        <input type="text" name="name" id="name" value="<%out.println(listAir.get(0).getAirportName());%>" required>
    </div>

    <div class="input">
        <label for="city">Город</label>
        <input type="text" name="city" id="city" value="<%out.println(listAir.get(0).getCity());%>" required>


    </div>



        <button class="button" type="submit">Сохранить</button>
</form>
        <button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AllAirportsServlet';">Отмена</button>





<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>

