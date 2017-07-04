package com.chernenko.controller.factories.employee.impl;


import com.chernenko.controller.MainController;
import com.chernenko.model.Employee;
import com.chernenko.service.EmployeeService;
import com.chernenko.service.impl.EmployeeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Anton on 09.04.2017.
 */
public class DeleteEmployee implements MainController {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String departmentName = request.getParameter("departmentName");
        String email = request.getParameter("email");
        Employee employee = new Employee();
        employee.setEmail(email);
        employeeService.deleteEmployee(employee);
        try {
            response.sendRedirect("http://localhost:8088/listEmployeesByDepartmentName?departmentName=" + departmentName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
