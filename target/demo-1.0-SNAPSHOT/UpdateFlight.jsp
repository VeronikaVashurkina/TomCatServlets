<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 19.04.2022
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.entitys.Flight" %>
<%@ page import="java.util.List" %>
<%@ page import="database.entitys.Airport" %>
<% List<Airport> listFly=(ArrayList)session.getAttribute("All"); %>
<% List<Flight> listAir=(ArrayList)session.getAttribute("One"); %>
<html>
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Изменить рейс</title>
  <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/normalize.css"/>
  <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1 class="title">Изменить рейс</h1>
<form action="/demo_war_exploded/UpdateFlightServlet?id=<%out.println(listAir.get(0).getFlightId());%>" method="post">
  <div class="input">

    <label for="name">Название</label>
    <input type="text" name="name" id="name" value="<%out.println(listAir.get(0).getFlightName());%>" required>
  </div>

  <div class="input">
    <label for="date">Дата</label>
    <input type="date" name="date" id="date" value="<%out.println(listAir.get(0).getFlightDate().toString().replace('-','.'));%>" required>
  </div>
  <div class="input">
    <label for="time">Время</label>
    <input type="time" name="time" id="time" value="<%out.println(listAir.get(0).getFlightTime());%>" required>
  </div>
  <div class="input">
    <label class="airport">Выберете аэропорт: </label>
    <select name="airport_id" required>
      <option selected>Выберите аэропорт</option>
      <%for (Airport item :
              listFly) {
        out.println("<option value=\""+item.getAirportId()+"\">"+item.getAirportId()+"</option>");
      }%>
    </select>
  </div>



  <button class="button" type="submit">Сохранить</button>
</form>
<button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AllFlightServlet';">Отмена</button>





<section class="link-main">
  <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>
