<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 19.04.2022
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.entitys.Airplane" %>
<%@ page import="java.util.List" %>
<% List<Airplane> list=(ArrayList)session.getAttribute("All"); %>



<html>
<head>
    <title>Все самолеты</title>
 <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
   <link rel="stylesheet" href="css/normalize.css"/>
   <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1 class="title">Все самолеты</h1>

    <table  class="table">
        <tr>
            <th >Код самолета</th>
            <th >Модель</th>
            <th >Вместительность</th>
            <th>Код рейса</th>
            <th ></th>
            <th ></th>
        </tr>

<%for (Airplane item :
        list) {
    out.println("<tr> "+"<td>"+item.getAirplaneId()+"</td>"+
               "<td>"+item.getAirplaneModel()+"</td>"+
            "<td>"+item.getAirplaneCapacity()+"</td>"+
            "<td>"+item.getFlightId()+"</td>"+
            "<td><a href=\"http://localhost:8086/demo_war_exploded/UpdateAirplaneServlet?id="+item.getAirplaneId()+"\">Редактировать</a></td>"+
    "<td><a href=\"http://localhost:8086/demo_war_exploded/DeleteAirplaneServlet?id="+item.getAirplaneId()+"\">Удалить</a></td>"+

    "</tr>"
    );
}%>

    </table>

<div class="button login">
<button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AddAirplaneServlet';"
><span>Добавить новый самолет</span> </button>
</div>

<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>
