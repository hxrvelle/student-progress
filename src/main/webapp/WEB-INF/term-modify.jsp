<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/term-creating-modifying.css">
  <script src="${pageContext.request.contextPath}/resources/js/functions.js"></script>
</head>
<body onload="setSelectedOption();">
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
  <section class="terms">
    <p>Для создания семестра заполните следующие данные и нажмите кнопку "Создать"</p>
    <br><br>
    <form action="/term-modify" method="post">
      <div class="input">
        <input type="hidden" value="${term.id}" name="id">
        <label for="input-field" class="input-label">Длительность (в неделях)</label>
        <input class="input-field" type="text" value="${term.duration}" name="duration">
      </div>
      <br><br>
      <div class="scroll">
        <label for="scroll-box" class="input-label" style="margin-right: 33px;">Дисциплины в семестре</label>
        <select class="scroll-box" name="disciplines" multiple>
          <c:forEach items="${allDisciplines}" var = "d">
            <option class="allDisciplines" value="${d.id}">${d.discipline}</option>
          </c:forEach>
        </select>
        <select style="display: none">
          <c:forEach items="${termDisciplines}" var = "d">
            <option class="activeDiscipline" value="${d.id}">${d.discipline}</option>
          </c:forEach>
        </select>
      </div>
      <input type="submit" class="action-button-type1" value="ПРИМЕНИТЬ" />
    </form>
    <br><br>
  </section>
  <c:if test="${message eq 1}">
    <br><br>
    <p style="color: red;">Поля не должны быть пустыми!</p>
  </c:if>
</div>
</body>
</html>