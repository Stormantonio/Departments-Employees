package com.chernenko.controller.factories.employee.impl;

import com.chernenko.controller.MainController;
import com.chernenko.controller.factories.employee.ActionEmployee;
import com.chernenko.controller.factories.employee.EmployeeForm;
import com.chernenko.model.Employee;
import com.chernenko.service.EmployeeService;
import com.chernenko.service.impl.EmployeeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Created by Anton on 22.06.2017.
 */
public class InsertEmployee implements MainController {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private EmployeeForm employeeForm = new EmployeeForm();

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String url = request.getRequestURL().toString();
        Employee employee = employeeForm.getEmployee(request);
        if (Objects.equals(url, ActionEmployee.insertEmployee.toString())) {
            employeeService.insertEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        try {
            response.sendRedirect("http://localhost:8088/listEmployeesByDepartmentName?departmentName=" + employee.getDepartment().getDepartmentName() /*departmentName*/);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
