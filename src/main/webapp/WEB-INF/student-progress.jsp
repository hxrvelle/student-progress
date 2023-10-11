<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/student-progress.css" type="text/css">
  <script src="${pageContext.request.contextPath}/resources/js/functions.js"></script>
  <script src="https://kit.fontawesome.com/47ae1cb85a.js" crossorigin="anonymous"></script>
</head>
<body onload="setIdDiscipline()">
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
      <form action="/student-progress" method="post">

      <table class="table-type3" name="disTable" style="width: 25%">
        <tr>
          <th>Дисциплина</th>
        </tr>
        <c:forEach items="${disciplines}" var="discipline">
          <tr>
            <td name="disCell">${discipline.discipline}<input type="hidden" name="disciplineIds" value="${discipline.id}"></td>
          </tr>
        </c:forEach>
      </table>

      <table class="table-type3" name="marksTable" style="width: 25%; text-align: center;">
        <tr>
          <th>Оценка</th>
        </tr>
        <c:forEach items="${marks}" var="mark">
        <tr>
          <c:if test="${mark.mark ne -1 && mark.mark ne 0}">
            <td name="markCell">
                <input type="hidden" name="disciplineId">
                ${mark.mark}
            </td>
          </c:if>
          <c:if test="${mark.mark eq 0 || mark.mark eq -1}">
            <td name="markCell">
              <input type="hidden" name="disciplineId">
              <input name="mark" type="text" class="input-field-type-2">
              <button type="submit" class="action-button-type4"><i class="fa-solid fa-check" style="color: #47cc00;"></i></button>
            </td>
          </c:if>
        </tr>
        </c:forEach>
      </table>
      <input type="hidden" name="selectedDis">

      </form>

      <div class="choose-period">
          <label class="period-label" for="idSelectedTerm">Выберите семестр</label>
          <form action="/student-progress" method="get" class="form">

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

            <input type="hidden" name="idToProgressHidden" value="${student.id}">
            <input type="submit" class="action-button-type3" value="ПРИМЕНИТЬ">

          </form>
        <div class="mid-mark">
          <p>Средняя оценка за семестр:
            <c:if test="${middleMark eq -1}">
              -
            </c:if>
            <c:if test="${middleMark ne -1}">
              ${middleMark}
            </c:if>
          </p>
        </div>
      </div>
    </div>
    <div class="clearfix"> </div>
  </section>
</div>
</body>
</html>