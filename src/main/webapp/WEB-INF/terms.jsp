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
                <form action="/terms" method="get" class="form">
                    <select name="idSelectedTerm" class="period">
                        <c:forEach items="${terms}" var="term">
                            <c:choose>
                                <c:when test="${term.id == selectedTerm.id}">
                                    <option selected class="data-option" value="${term.id}">${term.term}</option>
                                </c:when>
                                <c:otherwise>
                                    <option class="data-option" value="${term.id}">${term.term}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <input type="hidden" value="${term.id}">
                    <input type="submit" class="action-button-type3" value="ПРИМЕНИТЬ">
                </form>
        </div>
        <br><br>
        <p class="duration">Длительность семестра: ${duration}</p>
        <br><br>
        <p style="font-weight: bold;">Список дисциплин семестра</p>
        <br>
        <div class="progress">
            <table class="table-type3" style="width: 50%; float: left;">
                <tr>
                    <th>Наименование дисциплины</th>
                </tr>
                <c:forEach items="${disciplines}" var="d">
                    <tr>
                        <td id="discipline">${d.discipline}</td>
                    </tr>
                </c:forEach>
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
