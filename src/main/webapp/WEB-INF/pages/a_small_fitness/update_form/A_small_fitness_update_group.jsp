<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.10.2016
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new user</title>
    <spring:url value="/resources/css/first_work_page.css" var="style" />
    <spring:url value="/resources/css/normalize.css" var="normalize" />

    <link rel="stylesheet" type="text/css" href="${style}" >
    <link rel="stylesheet" type="text/css" href="${normalize}" >
</head>
<body>
<header class="header">
    <div class="container">
        <h1>World Sport Platform BF 1.0</h1>
        <h2>
            <small>Movement breeds success!</small>
        </h2>
    </div>
</header>
<!-- /HEADER -->
<!-- NAVIGATION -->
<nav class="page-navigation">
    <div class="container">
        <ul>
            <li><a href="#">Главная</a></li>
            <li><a href="/group/ShowGroupPage">Группы</a></li>
            <li><a href="/registerPerson/showFirstWorkPage">Кабинет</a></li>
            <%--<li><a href="#">Просмотр моей страници</a></li>--%>
            <%--<li><a href="#">Статистика</a></li>--%>
            <%--<li><a href="#">Расчеты</a></li>--%>
        </ul>

        <!-- LOGIN FORM -->
        <form action="#" class="login">
            <input type="text" placeholder="Login" required>
            <input type="password" placeholder="Password" required>
            <input type="submit" value="Sign In">
        </form>
        <!-- /LOGIN FORM -->
    </div>
</nav>

<div>
    <div>
        <input type="button" value="Add1">
        <input type="button" value="Add2">
        <input type="button" value="Add3">
        <input type="button" value="Add4">
    </div>
    <br/><br/>
    <br/><br/>

    <input type="button" value="найти">
    <input type="button" value="редактировать">
    <div style="font-weight: bold;
	width: 130px;
	padding: 5px 10px;
	margin-top: 30px;
	margin-left: 800px;
background: #cccccc; "  >

        <form:form method="get" action="delete">

        <input type="button" value="Добавить"
               onclick="window.location.href='showFormForAddGroup'; return false;" class="add-button"
        />
        <input type="submit" value="удалить">
        <input type="button" value="send email"
               onclick="window.location.href='showMailForm'; return false;" class="add-button"
        />
        <input type="button" value="Отправить смс">
            <%--<input type="button" value="отправить письмо">--%>
    </div>
</div>
<br/><br/>
<br/><br/>
<br/><br/>





<table border="3"  width="100%"   cellpadding="4" cellpacing="3">
    <tr>
        <th colspan="7">
            <h3><br>Группа №</h3>
        </th>
    </tr>
    <th>Имя</th>
    <th>Фамилия</th>
    <th>Телефон</th>
    <th>почта</th>
    <th>дата рождения</th>
    <th>должность</th>
    <th>комментарий</th>
    <th><input type="checkbox" id="selectall"></th>
    <c:forEach items="${students}" var="student">
        <tr align="center">
            <td>${student.name}</td>
            <td align="left">${student.surname}</td>
            <td align="left"></td>
            <td>${student.email}</td>
            <td>${student.birthday}</td>
            <td></td>
            <td></td>
            <td><input type="checkbox" class="case", name="case" value="${student.id}"></td>
            <td align="left"></td>
            <td>
                <!-- construct an "update" link with customer id -->
                <c:url var="updateLink" value="/registerPerson/showFormForUpdate" >
                    <c:param name="studentId" value="${student.id}"/>
                </c:url>

                <!-- display the update link -->
                <a href="${updateLink}">Редактировать</a>

            </td>
        </tr>
    </c:forEach>

</table>
</form:form>

<a href="../../A_small_fitness_first_work_Page.jsp"></a>
<footer class="footer">
    <div class="container">

    </div>
</footer>
</body>
</html>
