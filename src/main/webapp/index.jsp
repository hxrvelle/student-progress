<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index-page.css" type="text/css">
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
        <div class="logout">
            <a href="#">Logout</a>
        </div>
    </header>
    <section class="title">
        <h2>Система управления студентами и их успеваемостью</h2>
    </section>

    <section class="sections">
        <ul>
            <li><a href="/students">Студенты</a></li>
            <li><a href="/disciplines">Дисциплины</a></li>
            <li><a href="/terms">Семестры</a></li>
        </ul>
    </section>
</div>
</body>
</html>