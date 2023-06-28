<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="../css/main.css" type="text/css">
  <link rel="stylesheet" href="../css/disciplines-terms-list.css" type="text/css">
</head>
<body>
  <div class="wrapper">
    <header>
    <div class="logo">
      <img src="../images/logo.png">
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
        <button class="action-button-type2"><a href="/discipline-creating">СОЗДАТЬ ДИСЦИПЛИНУ</a></button>
        <button class="action-button-type2"><a href="/discipline-modifying">МОДИФИЦИРОВАТЬ ВЫБРАННУЮ ДИСЦИПЛИНУ</a></button>
        <button class="action-button-type2"><a href="#">УДАЛИТЬ ВЫБРАННУЮ ДИСЦИПЛИНУ</a></button>
      </div>
    </div>
    <div class="clearfix"> </div>
  </section>
</div>
</body>
</html>
