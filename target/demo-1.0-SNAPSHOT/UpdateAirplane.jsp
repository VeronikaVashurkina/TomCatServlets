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
<%@ page import="database.entitys.Airplane" %>
<% List<Flight> listFly=(ArrayList)session.getAttribute("All"); %>
<% List<Airplane> listAir=(ArrayList)session.getAttribute("One"); %>
<html>
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Изменить самолет</title>
  <!-- <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
   <link rel="stylesheet" href="css/normalize.css"/>
   <link rel="stylesheet" href="css/style.css"/>
   -->
</head>
<body>
<h1>Изменить самолет</h1>
<form action="/demo_war_exploded/UpdateAirplaneServlet?id=<%out.println(listAir.get(0).getAirplaneId());%>" method="post">
  <div class="input">
    <label for="model">Модель</label>
    <input type="text" name="model" id="model" value="<%out.println(listAir.get(0).getAirplaneModel());%>" required>
  </div>

  <div class="input">
    <label for="kg">Вместительность</label>
    <input type="text" name="kg" id="kg" value="<%out.println(listAir.get(0).getAirplaneCapacity());%>" required>
  </div>
  <label class="flight">Выберете рейс: </label>
  <select name="flight_id" required>
    <option selected>Выберите рейс</option>
    <%for (Flight item :
            listFly) {
      out.println("<option value=\""+item.getFlightId()+"\">"+item.getFlightId()+"</option>"
      );
    }%>
  </select>



  <div class="button login">
    <button style="width: 50%" type="submit">Сохранить</button>
    <button style="width: 50%" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/hello-servlet';">Отмена</button>
  </div>


</form>

<section class="link-main">
  <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>
