<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="css/list-employees.css"%>
</style>
<%
    String depName = request.getParameter("departmentName");
%>

<html>
<head>
    <title>Departments Store Application</title>
</head>
<body>
<form action="http://localhost:8088/listEmployeesByDepartmentName" method="post">
    <div class="fixed">
        <table class="menu-fix">
            <tr>
                <th class="th-menu-width">
                    <form></form>
                    <form action="http://localhost:8088/" method="get">
                        <input type="submit" value="MAIN PAGE">
                    </form>
                </th>
                <th class="th-menu-width">
                    <form action="http://localhost:8088/createEmployee?departmentName=<%= depName%>" method="post">
                        <input type="submit" value="ADD NEW EMPLOYEE">
                    </form>
                </th>
            </tr>
        </table>
    </div>
    <div class="main-column">
        <table class="table-content">
            <caption><h2>
                <%= depName%>
            </h2></caption>
            <tr>
                <th class="th-content">Surname</th>
                <th class="th-content">Name</th>
                <th class="th-content">Birth Date</th>
                <th class="th-content">Salary, USD</th>
                <th class="th-content">Email</th>
                <th class="th-content">Action</th>
            </tr>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td class="td-content"><c:out value="${employee.surname}"/></td>
                    <td class="td-content"><c:out value="${employee.name}"/></td>
                    <td class="td-content"><c:out value="${employee.birthDate}"/></td>
                    <td class="td-content"><c:out value="${employee.salary}"/></td>
                    <td class="td-content"><c:out value="${employee.email}"/></td>
                    <td class="td-content">
                        <form action="http://localhost:8088/changeEmployee?email=<c:out value='${employee.email}'/>&departmentName=<%= depName%>"
                              method="post">
                            <input type="submit" value="UPDATE">
                        </form>
                        <form action="http://localhost:8088/deleteEmployee?email=<c:out value='${employee.email}'/>&departmentName=<%= depName%>"
                              method="post">
                            <input type="submit" value="DELETE">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
