package com.chernenko.controller.factories.employee.impl;


import com.chernenko.controller.MainController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Anton on 09.04.2017.
 */
public class CreateEmployee implements MainController {

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String departmentName = request.getParameter("departmentName");
        try {
            response.sendRedirect("EmployeeForm.jsp?departmentName=" + departmentName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
