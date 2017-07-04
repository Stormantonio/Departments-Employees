package com.chernenko.controller.factories.department.impl;

import com.chernenko.controller.MainController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Anton on 07.04.2017.
 */
public class CreateDepartment implements MainController {

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        RequestDispatcher rd = request.getRequestDispatcher("DepartmentForm.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
