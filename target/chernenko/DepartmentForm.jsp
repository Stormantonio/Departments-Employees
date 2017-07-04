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
<p align="center">Add New Department</p>
<div>
    <form action="http://localhost:8088/insertDepartment" method="post">
        <label>Name of Department:</label><br>
        <input type="text" name="departmentName" placeholder="Name of Department" size="45"
               value="<c:out value='${department.departmentName}' />"/><br>
        <input type="submit" value="SAVE"/>
        <a href="http://localhost:8088/">
            <input type="button" value="CANCEL">
        </a>
    </form>
</div>
</body>
</html>