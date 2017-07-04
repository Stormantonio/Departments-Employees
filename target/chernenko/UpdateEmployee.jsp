<%@ page import="com.chernenko.service.DepartmentService" %>
<%@ page import="com.chernenko.service.impl.DepartmentServiceImpl" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 26.06.2017
  Time: 22:15
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
    <title>Departments Store Application</title>
</head>
<body>
<%
    DepartmentService departmentService = new DepartmentServiceImpl();
    try {
        request.setAttribute("departments", departmentService.listAllDepartments());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    String departmentName = request.getParameter("departmentName");
%>
<p align="center">Update Employee</p>
<div>
    <form action="http://localhost:8088/updateEmployee" method="post">

        <label>Name</label><br>
        <input name="name" type="text" value="<c:out value="${employee.name}"/>"><br>
        <label>Surname</label><br>
        <input name="surname" type="text" value="<c:out value="${employee.surname}"/>"><br>
        <label>Birth Date</label><br>
        <input name="birthDate" type="text" value="<c:out value="${employee.birthDate}"/>"><br>
        <label>Salary, USD</label><br>
        <input name="salary" type="text" value="<c:out value="${employee.salary}"/>"><br>
        <label>Email</label><br>
        <input name="email" type="text" value="<c:out value="${employee.email}"/>"><br>
        <label>Department</label><br>
        <select name="departmentName" class="dropdown">
            <option selected value="<%= departmentName%>"><%= departmentName%>
            </option>
            <c:forEach var="department" items="${departments}">
                <option value="<c:out value="${department.departmentName}"/>"><c:out
                        value="${department.departmentName}"/></option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input type="submit" value="UPDATE"/>
        <a href="http://localhost:8088/listEmployeesByDepartmentName?departmentName=<%= departmentName%>">
            <input type="button" value="CANCEL">
        </a>
    </form>
</div>
</body>
</html>
