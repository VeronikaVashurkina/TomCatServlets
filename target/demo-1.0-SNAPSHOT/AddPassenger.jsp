<%--
  Created by IntelliJ IDEA.
  User: Вероника
  Date: 18.04.2022
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.entitys.Airplane" %>
<%@ page import="java.util.List" %>
<% List<Airplane> list = (ArrayList) session.getAttribute("All"); %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Добавить пассажира</title>
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Puddles&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/style.css"/>


</head>
<body>
<h1 class="title">Добавить пассажира</h1>
<form action="/demo_war_exploded/AddPassengerServlet" method="post">
    <div class="input">
        <label for="surname">Фамилия</label>
        <input type="text" name="surname" id="surname" required>
    </div>
    <div class="input">
        <label for="name">Имя</label>
        <input type="text" name="name" id="name" required>
    </div>
    <div class="input">
        <label for="middle_name">Отчество</label>
        <input type="text" name="middle_name" id="middle_name" required>
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
        <input type="number" name="password" id="password" required>
    </div>
    <div class="input">
        <label for="natio">Национальность</label>
        <input type="text" name="natio" id="natio" required>
    </div>
    <div class="input">
        <label class="airplane">Выберете самолет: </label>
        <select name="airplane_id" required>
            <option selected>Выберите самолет</option>
            <%
                for (Airplane item :
                        list) {
                    out.println("<option value=\"" + item.getAirplaneId() + "\">" + item.getAirplaneId() + "</option>"
                    );
                }
            %>
        </select>
    </div>


    <div class="button login">
        <button class="button" type="submit">Добавить</button>
        <button class="button"
                onclick="window.location.href = 'http://localhost:8086/demo_war_exploded/AllPassengerServlet';">Отмена
        </button>
    </div>


</form>

<section class="link-main">
    <a title="Главная страница" name="link" href="http://localhost:8086/demo_war_exploded/"> Вернуться на главную</a>
</section>
</body>
</html>


