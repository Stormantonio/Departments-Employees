package com.chernenko.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Anton on 07.04.2017.
 */
public interface MainController {

    void doAction(HttpServletRequest request, HttpServletResponse response) throws SQLException;
}
