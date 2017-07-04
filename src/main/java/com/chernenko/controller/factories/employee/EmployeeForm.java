package com.chernenko.controller.factories.employee;

import com.chernenko.model.Department;
import com.chernenko.model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by Anton on 28.06.2017.
 */
public class EmployeeForm {

    public Employee getEmployee(HttpServletRequest request) {
        String departmentName = request.getParameter("departmentName");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dtf = dtf.withLocale(Locale.US);
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"), dtf);
        String sSalary = request.getParameter("salary");
        Double dSalary = Double.parseDouble(sSalary);
        String email = request.getParameter("email");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setBirthDate(birthDate);
        employee.setSalary(dSalary);
        employee.setEmail(email);
        Department department = new Department(departmentName);
        employee.setDepartment(department);
        return employee;
    }
}
