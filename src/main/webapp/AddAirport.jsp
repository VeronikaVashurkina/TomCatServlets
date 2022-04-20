<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 18.04.2022
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Добавить аэропорт</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>


</head>
<body>
<h1 class="title">Добавить Аэропорт</h1>
<form action="/demo_war_exploded/AddAirportServlet" method="post">
    <div class="input">
        <label for="name">Название</label>
        <input type="text" name="name" id="name" required>
    </div>


    <div class="input">
        <label for="city">Город</label>
        <input type="text" name="city" id="city" required>
    </div>


    <div class="button login">
        <button class="button" type="submit">Добавить</button>
        <button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AllAirportsServlet';">Отмена</button>
    </div>


</form>

<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>
