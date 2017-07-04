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
 * Created by Anton on 22.06.2017.
 */
public class InsertDepartment implements MainController {
    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String departmentName = request.getParameter("departmentName");
        departmentService.insertDepartment(new Department(departmentName));
        try {
            response.sendRedirect("http://localhost:8088/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
