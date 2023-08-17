<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/disciplines-terms-list.css" type="text/css">
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
    <p style="font-weight: bold;">Список дисциплин</p>
    <br>
    <div class="progress">
      <table class="table-type1" style="width: 50%; float: left;">
        <tr>
          <th></th>
          <th>Наименование дисциплины</th>
        </tr>
        <c:forEach items="${disciplines}" var = "d">
          <tr>
            <td><input type="checkbox"></td>
            <td>${d.discipline}</td>
          </tr>
        </c:forEach>
      </table>
      <div class="buttons">
        <form action="/discipline-creating" method="get">
          <input type="submit" class="action-button-type2" value="СОЗДАТЬ ДИСЦИПЛИНУ" />
        </form>
        <form action="/discipline-modifying" method="get">
          <input type="submit" class="action-button-type2" value="МОДИФИЦИРОВАТЬ ВЫБРАННУЮ ДИСЦИПЛИНУ" />
        </form>
        <form action="/" method="get">
          <input type="submit" class="action-button-type2" value="УДАЛИТЬ ВЫБРАННУЮ ДИСЦИПЛИНУ" />
        </form>
      </div>
    </div>
    <div class="clearfix"> </div>
  </section>
</div>
</body>
</html>
