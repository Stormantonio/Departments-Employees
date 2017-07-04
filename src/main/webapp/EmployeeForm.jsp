<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 03.04.2017
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="css/form.css"%>
</style>
<html>
<head>
    <title>Department Store Application</title>
</head>
<body>
<%
    String depN = request.getParameter("departmentName");
%>
<p align="center"><%= depN%>
</p>
<div>
    <form action="http://localhost:8088/insertEmployee?departmentName=<%= depN%>" method="post">
        <label>Name</label><br>
        <input type="text" name="name" placeholder="Name" size="45"
               value="<c:out value='${employee.name}'/>"/><br>
        <label>Surname</label><br>
        <input type="text" name="surname" placeholder="Surname" size="45"
               value="<c:out value='${employee.surname}'/>"/><br>
        <label>BirthDate</label><br>
        <input type="text" name="birthDate" placeholder="example: 1990-12-31" size="45"
               value="<c:out value='${employee.birthDate}'/>"/><br>
        <label>Salary, USD</label><br>
        <input type="text" name="salary" placeholder="example: 100.00" size="45"
               value="<c:out value='${employee.salary}'/>"/><br>
        <label>Email</label><br>
        <input type="text" name="email" placeholder="user@example.com" size="45"
               value="<c:out value='${employee.email}'/>"/><br>
        <br>
        <input type="submit" value="ADD NEW EMPLOYEE"/>
        <a href="http://localhost:8088/listEmployeesByDepartmentName?departmentName=<%= depN%>">
            <input type="button" value="CANCEL">
        </a>
    </form>
</div>
</body>
</html>

