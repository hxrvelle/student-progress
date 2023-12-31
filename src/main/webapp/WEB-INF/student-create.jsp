<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/student-modifying-creating.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker({dateFormat: "dd/mm/yy"});
        } );
    </script>
</head>
<body>
<div class="wrapper">
    <header>
        <div class="logo">
            <img src="${pageContext.request.contextPath}/resources/images/logo.png">
        </div>
        <div class="back_to_main">
            <a href="/">На главную</a>
        </div>
        <div class="back">
            <a href="#" onclick="history.back()">Назад</a>
        </div>
        <c:choose>
            <c:when test="${isLogged == true}">
                <div class="logout">
                    <a href="/logout">Logout</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="logout">
                    <a href="/login">Login</a>
                </div>
            </c:otherwise>
        </c:choose>
    </header>
    <section class="title">
        <h2>Система управления студентами и их успеваемостью</h2>
    </section>
    <section class="modify">
        <p>Для создания студента заполните все поля и нажмите кнопку "Создать"</p>
        <br>
        <form action="/student-create" method="post">
            <ul class="fields">
                <li><input class="input-field" type="text" name="surname" placeholder="Фамилия"></li>
                <li><input class="input-field" type="text" name="group" placeholder="Группа"></li>
            </ul>
            <ul class="fields">
                <li><input class="input-field" type="text" name="name" placeholder="Имя"></li>
                <li><input id="datepicker" class="input-field" type="text" name="date" placeholder="Дата поступления"></li>
            </ul>
            <br>
            <input type="submit" class="action-button-type1" value="СОЗДАТЬ" />
        </form>
    </section>
    <c:if test="${message eq 1}">
        <br><br>
        <p style="color: red;">Поля не должны быть пустыми!</p>
    </c:if>
</div>
</body>
</html>
