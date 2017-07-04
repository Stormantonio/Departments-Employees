package com.chernenko.controller.factories.department.impl;

import com.chernenko.controller.MainController;
import com.chernenko.model.Department;
import com.chernenko.service.DepartmentService;
import com.chernenko.service.impl.DepartmentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Anton on 08.04.2017.
 */
public class DeleteDepartment implements MainController {
    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String departmentName = request.getParameter("departmentName");
        Department department = new Department(departmentName);
        departmentService.deleteDepartment(department);
        try {
            response.sendRedirect("http://localhost:8088/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
