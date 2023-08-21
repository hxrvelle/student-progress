<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/discipline-creating-modifying.css">
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
  <section class="inputs">
    <section class="inputs">
    <p>Для того, чтобы модифицировать дисциплину, введите новые значения в поля и нажмите кнопку "Применить"</p>
    <br><br>
    <form action="/discipline-modify" method="post">
      <input type="hidden" name="id" value="${discipline.id}">
      <input class="input-field" type="text" name="discipline" value="${discipline.discipline}">
      <br><br>
      <input type="submit" class="action-button-type1" value="ПРИМЕНИТЬ">
    </form>
  </section>
  <c:if test="${message eq 1}">
    <br><br>
    <p style="color: red;">Поле не должно быть пустым!</p>
  </c:if>
</div>
</body>
</html>
