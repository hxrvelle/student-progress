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
    <div class="logout">
      <a href="#">Logout</a>
    </div>
  </header>
  <section class="title">
    <h2>Система управления студентами и их успеваемостью</h2>
  </section>
  <section class="modify">
    <p>Для модификации, введите новые значения и нажмите кнопку "Применить"</p>
    <br>
    <form action="/student-modify" method="post">
      <input type="hidden" name="id" value="${student.id}">
      <ul class="fields">
        <li><input class="input-field" type="text" name="surname" value="${student.surname}"></li>
        <li><input class="input-field" type="text" name="group" value="${student.group}"></li>
      </ul>
      <ul class="fields">
        <li><input class="input-field" type="text" name="name" value="${student.name}"></li>
        <li><input id="datepicker" class="input-field" type="text" name="date" value="${student.date}"></li>
      </ul>
      <br>
      <input type="submit" class="action-button-type1" value="ПРИМЕНИТЬ" />
    </form>
  </section>
</div>
</body>
</html>