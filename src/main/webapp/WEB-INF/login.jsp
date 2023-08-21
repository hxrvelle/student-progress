<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css">
</head>
<body>
    <div class="wrapper">
    <header>
        <div class="logo">
            <img src="${pageContext.request.contextPath}/resources/images/logo.png">
        </div>
    </header>
        <div class="info">
            <p>Тестовые аккаунты:</p>
            <p>Администратор: admin // a123</p>
            <p>Студент: student // s123</p>
        </div>
            <form action="/login" method="post">
                <input name="login" type="text" class="loginField" placeholder="login" />
                <br>
                <br>
                <input name="password" type="text" class="loginField" placeholder="password" />
                <br>
                <br>
                <select name="role" class="loginFieldSelect" placeholder="role">
                    <option value="1">Администратор</option>
                    <option value="2">Учитель</option>
                    <option value="3">Студент</option>
                </select>
                <br>
                <br>
                <input type="submit" value="Войти" class="action-button-type3" />
            </form>
            <c:if test="${message eq 1}">
                <p>Поля не должны быть пустыми</p>
            </c:if>
            <c:if test="${message eq 2}">
                <p>Неверные данные</p>
            </c:if>
    </div>
</body>
</html>
