package com.chernenko.controller.factories.employee.impl;

import com.chernenko.controller.MainController;
import com.chernenko.service.EmployeeService;
import com.chernenko.service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Anton on 26.06.2017.
 */
public class ChangeEmployee implements MainController {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String email = request.getParameter("email");
        request.setAttribute("employee", employeeService.getEmployeeByEmail(email));
        RequestDispatcher rd = request.getRequestDispatcher("UpdateEmployee.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
