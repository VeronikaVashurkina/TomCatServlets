<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 19.04.2022
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.entitys.Luggage" %>
<%@ page import="java.util.List" %>
<% List<Luggage> list=(ArrayList)session.getAttribute("All"); %>



<html>
<head>
    <title>Весь багаж</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1 class="title">Весь багаж</h1>

<table  class="table">
    <tr>
        <th >Код багажа</th>
        <th >Вес</th>
        <th>Код пассажира</th>
        <th ></th>
        <th ></th>
    </tr>

    <%for (Luggage item :
            list) {
        out.println("<tr> "+"<td>"+item.getLuggageId()+"</td>"+
                "<td>"+item.getLuggageWeight()+"</td>"+
                "<td>"+item.getPassengerId()+"</td>"+
                "<td><a href=\"http://localhost:8086/demo_war_exploded/UpdateLuggageServlet?id="+item.getLuggageId()+"\">Редактировать</a></td>"+
                "<td><a href=\"http://localhost:8086/demo_war_exploded/DeleteLuggageServlet?id="+item.getLuggageId()+"\">Удалить</a></td>"+

                "</tr>"
        );
    }%>

</table>

<div class="button login">
    <button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AddLuggageServlet';"
    ><span>Добавить новый багаж</span> </button>
</div>

<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>

