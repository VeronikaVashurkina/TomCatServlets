<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 19.04.2022
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.entitys.Flight" %>
<%@ page import="java.util.List" %>
<% List<Flight> list=(ArrayList)session.getAttribute("All"); %>



<html>
<head>
    <title>Все самолеты</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1 class="title">Все рейсы</h1>

<table  class="table">
    <tr>
        <th >Код рейса</th>
        <th >Название</th>
        <th >Дата</th>
        <th >Время</th>
        <th>Код аэропорта</th>
        <th ></th>
        <th ></th>
    </tr>

    <%for (Flight item :
            list) {
        out.println("<tr> "+"<td>"+item.getFlightId()+"</td>"+
                "<td>"+item.getFlightName()+"</td>"+
                "<td>"+item.getFlightDate()+"</td>"+
                "<td>"+item.getFlightTime()+"</td>"+
                "<td>"+item.getAirportId()+"</td>"+
                "<td><a href=\"http://localhost:8086/demo_war_exploded/UpdateFlightServlet?id="+item.getFlightId()+"\">Редактировать</a></td>"+
                "<td><a href=\"http://localhost:8086/demo_war_exploded/DeleteFlightServlet?id="+item.getFlightId()+"\">Удалить</a></td>"+

                "</tr>"
        );
    }%>

</table>

<div class="button login">
    <button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AddFlightServlet';"
    ><span>Добавить новый рейс</span> </button>
</div>

<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>

