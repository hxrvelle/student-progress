<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/students-list.css" type="text/css">
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
    <section class="sections-buttons">
        <ul class="first-row">
            <li>
                <input type="submit" class="action-button-type2" onclick="progressStudent()" value="ПРОСМОТРЕТЬ УСПЕВАЕМОСТЬ ВЫБРАННОГО СТУДЕНТОВ" />
            </li>
            <li>
                <form action="/student-create" method="get">
                    <input type="submit" class="action-button-type2" value="СОЗДАТЬ СТУДЕНТА" />
                </form>
            </li>
        </ul>
        <ul class="second-row">
            <li>
                <input type="submit" class="action-button-type2" onclick="modifyStudent()" value="МОДИФИЦИРОВАТЬ ВЫБРАННОГО СТУДЕНТА" />
            </li>
            <li>
                <input type="submit" class="action-button-type2" onclick="deleteStudents()" value="УДАЛИТЬ ВЫБРАННЫХ СТУДЕНТОВ" />
            </li>
        </ul>
    </section>

    <section class="table">
        <h3>Список студентов</h3>
        <table class="table-type1">
            <tr>
                <th></th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Группа</th>
                <th>Дата поступления</th>
            </tr>
            <c:forEach items="${students}" var="st">
                <tr>
                    <td><input type="checkbox" value="${st.id}" name="idStud"></td>
                    <td id="surname">${st.surname}</td>
                    <td id="name">${st.name}</td>
                    <td id="group">${st.group}</td>
                    <td id="date"><fmt:formatDate value="${st.date}" pattern="dd/MM/yyyy" /></td>
                </tr>
            </c:forEach>
        </table>
    </section>
</div>

<form action="/student-delete" method="post" id="formDelete">
    <input type="hidden" id="idsToDeleteHidden" name="idsToDeleteHidden">
</form>
<form action="/student-modify" method="get" id="formModify">
    <input type="hidden" id="idToModifyHidden" name="idToModifyHidden">
</form>
<form action="/student-progress" method="get" id="formProgress">
    <input type="hidden" id="idToProgressHidden" name="idToProgressHidden">
</form>
</body>
</html>