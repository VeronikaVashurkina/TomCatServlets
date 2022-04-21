<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 18.04.2022
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.entitys.Passenger" %>
<%@ page import="java.util.List" %>
<% List<Passenger> list=(ArrayList)session.getAttribute("All"); %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Добавить багаж</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>


</head>
<body>
<h1 class="title">Добавить багаж</h1>
<form action="/demo_war_exploded/AddLuggageServlet" method="post">

    <div class="input">
        <label for="kg">Вес</label>
        <input type="text" name="kg" id="kg" required>
    </div>
    <div class="input">
        <label class="passenger">Выберете пассажира: </label>
        <select name="passenger_id" required>
            <option selected>Выберите пассажира</option>
            <%for (Passenger item :
                    list) {
                out.println("<option value=\""+item.getPassengerId()+"\">"+item.getPassengerId()+"</option>"
                );
            }%>
        </select>
    </div>


    <div class="button login">
        <button class="button" type="submit">Добавить</button>
        <button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AllLuggageServlet';">Отмена</button>
    </div>


</form>

<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>


