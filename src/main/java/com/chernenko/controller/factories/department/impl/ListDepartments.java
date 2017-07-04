package com.chernenko.controller.factories.department.impl;

import com.chernenko.controller.MainController;
import com.chernenko.service.DepartmentService;
import com.chernenko.service.impl.DepartmentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Anton on 08.04.2017.
 */
public class ListDepartments implements MainController {
    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        request.setAttribute("departments", departmentService.listAllDepartments());
        RequestDispatcher rd = request.getRequestDispatcher("DepartmentList.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
