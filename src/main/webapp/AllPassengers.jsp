<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 19.04.2022
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.entitys.Passenger" %>
<%@ page import="java.util.List" %>
<% List<Passenger> list=(ArrayList)session.getAttribute("All"); %>



<html>
<head>
    <title>Все пассажиры</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1 class="title">Все пассажиры</h1>

<table  class="table">
    <tr>
        <th >Код пассажира</th>
        <th >Фамилия</th>
        <th >Имя</th>
        <th>Отчество</th>
        <th>Пол</th>
        <th>Паспорт</th>
        <th>Национальность</th>
        <th ></th>
        <th ></th>
    </tr>

    <%for (Passenger item :
            list) {
        out.println("<tr> "+"<td>"+item.getPassengerId()+"</td>"+
                "<td>"+item.getPassengerSurname()+"</td>"+
                "<td>"+item.getPassengerName()+"</td>"+
                "<td>"+item.getPassengerMiddleName()+"</td>"+
                "<td>"+item.getPassengerSex()+"</td>"+
                "<td>"+item.getPassengerPassword()+"</td>"+
                "<td>"+item.getPassengerNationality()+"</td>"+
                "<td><a href=\"http://localhost:8086/demo_war_exploded/UpdatePassengerServlet?id="+item.getAirplaneId()+"\">Редактировать</a></td>"+
                "<td><a href=\"http://localhost:8086/demo_war_exploded/DeletePassengerServlet?id="+item.getAirplaneId()+"\">Удалить</a></td>"+

                "</tr>"
        );
    }%>

</table>

<div class="button login">
    <button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AddPassengerServlet';"
    ><span>Добавить нового пассажира</span> </button>
</div>

<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>
