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
<%@ page import="database.entitys.Airplane" %>
<%@ page import="database.entitys.Passenger" %>
<% List<Airplane> listFly=(ArrayList)session.getAttribute("All"); %>
<% List<Passenger> listAir=(ArrayList)session.getAttribute("One"); %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Изменить пассажира</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1 class="title">Изменить пассажира</h1>
<form action="/demo_war_exploded/UpdatePassengerServlet?id=<%out.println(listAir.get(0).getPassengerId());%>" method="post">
    <div class="input">
        <label for="surname">Фамилия</label>
        <input type="text" name="surname" id="surname" value="<%out.println(listAir.get(0).getPassengerSurname());%>" required>
    </div>
    <div class="input">
        <label for="name">Имя</label>
        <input type="text" name="name" id="name"  value="<%out.println(listAir.get(0).getPassengerName());%>" required>
    </div>
    <div class="input">
        <label for="middle_name">Отчество</label>
        <input type="text" name="middle_name" id="middle_name" value="<%out.println(listAir.get(0).getPassengerMiddleName());%>" required>
    </div>
    <div class="input">
        <label class="sex">Выберете пол: </label>
        <select name="sex" required>
            <option selected>Выберите пол</option>
            <option value="Жен">Жен</option>
            <option value="Муж">Муж</option>
        </select>
    </div>
    <div class="input">
        <label for="password">Паспорт</label>
        <input type="text" name="password" id="password" value="<%out.println(listAir.get(0).getPassengerPassword());%>" required>
    </div>
    <div class="input">
        <label for="natio">Национальность</label>
        <input type="text" name="natio" id="natio" value="<%out.println(listAir.get(0).getPassengerNationality());%>" required>
    </div>
    <div class="input">
        <label class="airplane">Выберете самолет: </label>
        <select name="airplane_id" required>
            <option selected>Выберите самолет</option>
            <%
                for (Airplane item :
                        listFly) {
                    out.println("<option value=\"" + item.getAirplaneId() + "\">" + item.getAirplaneId() + "</option>"
                    );
                }
            %>
        </select>
    </div>


    <button class="button" type="submit">Сохранить</button>
</form>
<button class="button" onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AllPassengersServlet';">Отмена</button>





<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>
