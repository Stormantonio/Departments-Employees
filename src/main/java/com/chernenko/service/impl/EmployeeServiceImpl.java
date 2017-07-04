package com.chernenko.service.impl;

import com.chernenko.dao.EmployeeDao;
import com.chernenko.dao.impl.EmployeeDaoImpl;
import com.chernenko.model.Employee;
import com.chernenko.service.EmployeeService;
import com.chernenko.util.ConnectData;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Anton on 09.04.2017.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private final String jdbcURL = "jdbc:postgresql://localhost:5432/departments_data";
    private final String jdbcUsername = "postgres";
    private final String jdbcPassword = "0000";

    private ConnectData connectData = new ConnectData(jdbcURL, jdbcUsername, jdbcPassword);

    private EmployeeDao employeeDao = new EmployeeDaoImpl(connectData);

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentName(String departmentName) throws SQLException {
        List<Employee> employees = employeeDao.getEmployeesByDepartmentName(departmentName);
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        return employees;
    }

    @Override
    public Employee getEmployeeByEmail(String email) throws SQLException {
        return employeeDao.getEmployeeByEmail(email);
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) throws SQLException {
        employeeDao.deleteEmployee(employee);
    }
}
