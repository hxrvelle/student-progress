<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/student-modifying-creating.css">
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
  <section class="terms">
    <p>Для создания семестра заполните следующиие данные и нажмите кнопку "Создать"</p>
    <br><br>
    <div class="input">
      <label for="input-field" class="input-label">Длительность (в неделях)</label>
      <input class="input-field" type="text" placeholder="24" name="input-field">
    </div>
    <br><br>
    <div class="scroll">
      <label for="scroll-box" class="input-label" style="margin-right: 33px;">Дисциплины в семестре</label>
      <div class="scroll-box" name="scroll-box">
        <ul>
          <li>Информатика</li>
          <li>Политология</li>
          <li>Социология</li>
          <li class="active">Высшая математика</li>
          <li>Теория алгоритмизации</li>
          <li>Теория игр</li>
          <li>Булевая алгебра</li>
          <li>Системный анализ</li>
          <li class="active">Информатика</li>
          <li class="active">Политология</li>
          <li>Социология</li>
          <li>Высшая математика</li>
          <li>Теория алгоритмизации</li>
          <li>Теория игр</li>
          <li>Булевая алгебра</li>
          <li>Системный анализ</li>
          <li>Информатика</li>
          <li>Политология</li>
          <li class="active">Социология</li>
          <li>Высшая математика</li>
          <li class="active">Теория алгоритмизации</li>
          <li>Теория игр</li>
          <li>Булевая алгебра</li>
          <li class="active">Системный анализ</li>
          <li>Информатика</li>
          <li>Политология</li>
          <li>Социология</li>
          <li>Высшая математика</li>
          <li>Теория алгоритмизации</li>
          <li>Теория игр</li>
          <li>Булевая алгебра</li>
          <li>Системный анализ</li>
        </ul>
      </div>
    </div>
    <br><br>
    <input type="submit" class="action-button-type1" value="СОЗДАТЬ"></input>
  </section>
  <br><br>
</div>
</body>
</html>
