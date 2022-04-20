<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 19.04.2022
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.entitys.Airport" %>
<%@ page import="java.util.List" %>
<% List<Airport> list=(ArrayList)session.getAttribute("All"); %>



<html>
<head>
    <title>Все аэропорты</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1 class="title">Все аэропорты</h1>

<table  class="table">
    <tr>
        <th >Код аэропорта</th>
        <th >Название</th>
        <th >Город</th>
        <th ></th>
        <th ></th>
    </tr>

    <%for (Airport item :
            list) {
        out.println("<tr> "+"<td>"+item.getAirportId()+"</td>"+
                "<td>"+item.getAirportName()+"</td>"+
                "<td>"+item.getCity()+"</td>"+
                "<td><a href=\"http://localhost:8086/demo_war_exploded/UpdateAirportServlet?id="+item.getAirportId()+"\">Редактировать</a></td>"+
                "<td><a href=\"http://localhost:8086/demo_war_exploded/DeleteAirportServlet?id="+item.getAirportId()+"\">Удалить</a></td>"+

                "</tr>"
        );
    }%>

</table>

<div class="button login">
    <button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AddAirportServlet';"
    ><span>Добавить новый аэропорт</span> </button>
</div>

<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>