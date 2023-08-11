<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/student-progress.css" type="text/css">
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
    <div class="logout">
      <a href="#">Logout</a>
    </div>
  </header>
  <section class="title">
    <h2>Система управления студентами и их успеваемостью</h2>
  </section>
  <section class="student-progress">
    <p>Отображена успеваемость для следующего студента:</p>
    <br>
    <table class="table-type2">
      <tr>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Группа</th>
        <th>Дата поступления</th>
      </tr>
      <tr>
        <td>${student.surname}</td>
        <td>${student.name}</td>
        <td>${student.group}</td>
        <td>${student.date}</td>
      </tr>
    </table>
    <div class="progress">
      <table class="table-type3">
        <tr>
          <th>Дисциплина</th>
          <th>Оценка</th>
        </tr>
        <tr>
          <td>Информатика</td>
          <td>5</td>
        </tr>
        <tr>
          <td>Системный Анализ</td>
          <td>4</td>
        </tr>
        <tr>
          <td>Управление проектами</td>
          <td>5</td>
        </tr>
        <tr>
          <td>Основы Дискретной Математики</td>
          <td>4</td>
        </tr>
      </table>

      <div class="choose-period">
        <%--@declare id="period"--%>
        <label class="period-label" for="period">Выберите семестр</label>
        <select name="period" class="period">
          <c:forEach items="${terms}" var = "term">
            <c:choose>
              <c:when test="${term.id == selectedTerm.id}">
                <option selected class="data-option" id="${term.id}">${term.term}</option>
              </c:when>
              <c:otherwise>
                <option class="data-option" id="${term.id}">${term.term}</option>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </select>
          <form>
            <input type="submit" class="action-button-type3" value="ПРИМЕНИТЬ">
          </form>
        <div class="mid-mark">
          <p>Средняя оценка за семестр: 4,8 балла</p>
        </div>
      </div>
    </div>
    <div class="clearfix"> </div>
  </section>
</div>
</body>
</html>