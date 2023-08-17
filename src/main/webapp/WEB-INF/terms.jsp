<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/disciplines-terms-list.css" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/functions.js"></script>
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
    <section class="disciplines">
        <div class="choose-period">
            <%--@declare id="period"--%>
            <label class="period-label" for="period">Выберите семестр</label>
            <select name="period" class="period">
                <option class="data-option">Выберите семестр</option>
                <c:forEach items="${terms}" var = "t">
                    <option class="data-option" id="${t.id}">${t.term}</option>
                </c:forEach>
            </select>
            <button class="action-button-type3" onclick="setSelected()"><a href="#">ПРИМЕНИТЬ</a></button>
        </div>
        <br><br>
        <p class="duration">Длительность семестра:<c:out value="${terms[1].duration}" /></p>
        <br><br>
        <p style="font-weight: bold;">Список дисциплин семестра</p>
        <br>
        <div class="progress">
            <table class="table-type3" style="width: 50%; float: left;">
                <tr>
                    <th>Наименование дисциплины</th>
                </tr>
                <tr>
                    <td>Высшая математика</td>
                </tr>
                <tr>
                    <td>История Науки и Техники</td>
                </tr>
                <tr>
                    <td>Политология</td>
                </tr>
                <tr>
                    <td>Информатика</td>
                </tr>
                <tr>
                    <td>Теория Алгоритмизации</td>
                </tr>
            </table>
            <div class="buttons">
                <form action="/term-creating" method="get">
                    <input type="submit" class="action-button-type2" value="СОЗДАТЬ СЕМЕСТР" />
                </form>
                <form action="/term-modifying" method="get">
                    <input type="submit" class="action-button-type2" value="МОДИФИЦИРОВАТЬ ТЕКУЩИЙ СЕМЕСТР" />
                </form>
                <form action="/" method="get">
                    <input type="submit" class="action-button-type2" value="УДАЛИТЬ ТЕКУЩИЙ СЕМЕСТР" />
                </form>
            </div>
        </div>
        <div class="clearfix"> </div>
    </section>
</div>
</body>
</html>
