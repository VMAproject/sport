<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.10.2016
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>register like a trainer</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}navbar-static-top.css" rel="stylesheet">

</head>
<body>
<form:form action="showFirstWorkPage" >

    <div class="container">
        <div class="jumbotron">
            <h1>Trainer</h1>
            <p>Registration page <strong></strong> </p>
            <p>маленький подарок русский буквы нормально отображаются)</p>
            <p><input type="submit" value="Submit"></p>
        </div>

    </div>



</form:form>
</body>
</html>
