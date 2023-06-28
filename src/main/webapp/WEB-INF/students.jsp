<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/main.css" type="text/css">
    <link rel="stylesheet" href="../css/students-list.css" type="text/css">
</head>
<body>
<div class="wrapper">
    <header>
        <div class="logo">
            <img src="../images/logo.png">
        </div>
        <div class="back_to_main">
            <a href="/">На главную</a>
        </div>
        <div class="logout">
            <a href="#">Logout</a>
        </div>
    </header>
    <section class="title">
        <h2>Система управления студентами и их успеваемостью</h2>
    </section>
    <section class="sections-buttons">
        <ul class="first-row">
            <li><button class="action-button-type2"><a href="/student-progress">ПРОСМОТРЕТЬ УСПЕВАЕМОСТЬ ВЫБРАННЫХ СТУДЕНТОВ</a></button></li>
            <li><button class="action-button-type2"><a href="/student-creating">СОЗДАТЬ СТУДЕНТА</a></button></li>
        </ul>
        <ul class="second-row">
            <li><button class="action-button-type2"><a href="/student-modifying">МОДИФИЦИРОВАТЬ ВЫБРАННОГО СТУДЕНТА</a></button></li>
            <li><button class="action-button-type2"><a href="#">УДАЛИТЬ ВЫБРАННЫХ СТУДЕНТОВ</a></button></li>
        </ul>
    </section>

    <section class="table">
        <h3>Список студентов</h3>
        <table class="table-type1">
            <tr>
                <th></th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Группа</th>
                <th>Дата поступления</th>
            </tr>
            <c:forEach items="${students}" var="st">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${st.surname}</td>
                    <td>${st.name}</td>
                    <td>${st.group}</td>
                    <td>${st.date}</td>
                </tr>
            </c:forEach>
        </table>
    </section>
</div>
</body>
</html>