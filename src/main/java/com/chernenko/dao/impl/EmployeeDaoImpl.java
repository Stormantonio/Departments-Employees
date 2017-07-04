package com.chernenko.dao.impl;

import com.chernenko.dao.EmployeeDao;
import com.chernenko.model.Department;
import com.chernenko.model.Employee;
import com.chernenko.util.ConnectData;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 02.04.2017.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private ConnectData connectData = new ConnectData();

    public EmployeeDaoImpl(ConnectData connectData) {
        this.connectData = connectData;
    }

    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {

        String sql = "INSERT INTO employees (name, surname, birth_date, salary, email, department) VALUES (?,?,?,?,?,?)";
        connectData.connect();

        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getSurname());
        ps.setDate(3, Date.valueOf(employee.getBirthDate()));
        ps.setDouble(4, employee.getSalary());
        ps.setString(5, employee.getEmail());
        ps.setString(6, employee.getDepartment().getDepartmentName());

        boolean rowInserted = ps.executeUpdate() > 0;
        ps.close();
        connectData.disconnect();
        return rowInserted;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentName(String departmentName) throws SQLException {

        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE department=?";
        connectData.connect();
        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
        ps.setString(1, departmentName);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            Date birthDate = rs.getDate("birth_date");
            Double salary = rs.getDouble("salary");
            String email = rs.getString("email");
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSurname(surname);
            employee.setBirthDate(birthDate.toLocalDate());
            employee.setSalary(salary);
            employee.setEmail(email);
            employees.add(employee);
        }
        rs.close();
        ps.close();
        connectData.disconnect();
        return employees;
    }

    @Override
    public Employee getEmployeeByEmail(String email) throws SQLException {
        Employee employee = new Employee();
        String sql = "SELECT department, name, surname, birth_date, salary FROM employees WHERE email=?";
        connectData.connect();
        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            String departmentName = rs.getString("department");
            Department department = new Department(departmentName);

            String name = rs.getString("name");
            String surname = rs.getString("surname");
            Date birthDate = rs.getDate("birth_date");
            Double salary = rs.getDouble("salary");

            employee.setName(name);
            employee.setSurname(surname);
            employee.setBirthDate(birthDate.toLocalDate());
            employee.setSalary(salary);
            employee.setEmail(email);
            employee.setDepartment(department);
        }
        rs.close();
        ps.close();
        return employee;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {

        String sql = "UPDATE employees SET name=?, surname=?, birth_date=?, salary=?, department=? WHERE email=?";
        connectData.connect();

        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getSurname());
        ps.setDate(3, Date.valueOf(employee.getBirthDate()));
        ps.setDouble(4, employee.getSalary());
        ps.setString(5, employee.getDepartment().getDepartmentName());
        ps.setString(6, employee.getEmail());
        boolean rowEdited = ps.executeUpdate() > 0;
        ps.close();
        connectData.disconnect();
        return rowEdited;
    }

    @Override
    public boolean deleteEmployee(Employee employee) throws SQLException {

        String sql = "DELETE FROM employees WHERE email=?";
        connectData.connect();

        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
        ps.setString(1, employee.getEmail());

        boolean rowDeleted = ps.executeUpdate() > 0;
        ps.close();
        connectData.disconnect();
        return rowDeleted;
    }
}
