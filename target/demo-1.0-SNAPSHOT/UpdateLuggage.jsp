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
<%@ page import="database.entitys.Passenger" %>
<%@ page import="database.entitys.Luggage" %>
<% List<Passenger> listFly=(ArrayList)session.getAttribute("All"); %>
<% List<Luggage> listAir=(ArrayList)session.getAttribute("One"); %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Изменить багаж</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1 class="title">Изменить багаж</h1>
<form action="/demo_war_exploded/UpdateLuggageServlet?id=<%out.println(listAir.get(0).getLuggageId());%>" method="post">
    <div class="input">
        <label for="kg">Вес</label>
        <input type="text" name="kg" id="kg" value="<%out.println(listAir.get(0).getLuggageWeight());%>" required>
    </div>
    <div class="input">
        <label class="passenger">Выберете пассажира: </label>
        <select name="passenger_id" required>
            <option selected>Выберите пассажира</option>
            <%for (Passenger item :
                    listFly) {
                out.println("<option value=\""+item.getPassengerId()+"\">"+item.getPassengerId()+"</option>"
                );
            }%>
        </select>
    </div>



    <button class="button" type="submit">Сохранить</button>
</form>
<button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AllLuggageServlet';">Отмена</button>





<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>

