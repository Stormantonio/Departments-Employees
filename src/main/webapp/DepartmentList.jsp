<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="css/department-list.css"%>
</style>
<html>
<head>
    <title>Departments Store Application</title>
</head>
<body>
<div class="fix-department">
    <form action="http://localhost:8088/createDepartment" method="get">
        <input type="submit" value="NEW DEPARTMENT">
    </form>
</div>
<div class="div-departments">
    <table class="table-department">
        <caption><h2>Departments</h2></caption>

        <c:forEach var="department" items="${departments}">
            <tr>
                <td class="td-departments">
                    <form></form>
                    <form action="http://localhost:8088/listEmployeesByDepartmentName?departmentName=<c:out value='${department.departmentName}'/>"
                          method="post">
                        <input type="submit" value="<c:out value="${department.departmentName}"/>">
                    </form>
                </td>
                <td class="td-departments">
                    <form action="http://localhost:8088/deleteDepartment?departmentName=<c:out value='${department.departmentName}'/>"
                          method="post">
                        <input type="submit" value="DELETE">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
