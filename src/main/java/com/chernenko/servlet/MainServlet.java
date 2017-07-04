package com.chernenko.servlet;

import com.chernenko.controller.MainController;
import com.chernenko.controller.factories.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Anton on 02.04.2017.
 */
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        Factory factory = new Factory();
        MainController controller = factory.getController(url);
        try {
            controller.doAction(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
