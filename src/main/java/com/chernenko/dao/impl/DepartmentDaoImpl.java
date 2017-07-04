package com.chernenko.dao.impl;

import com.chernenko.dao.DepartmentDao;
import com.chernenko.model.Department;
import com.chernenko.util.ConnectData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 02.04.2017.
 */
public class DepartmentDaoImpl implements DepartmentDao {
    private ConnectData connectData;

    public DepartmentDaoImpl(ConnectData connectData) {
        this.connectData = connectData;
    }

    public boolean insertDepartment(Department department) throws SQLException {
        String sql = "INSERT INTO departments (department_name) VALUES (?)";
        connectData.connect();

        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
        ps.setString(1, department.getDepartmentName());

        boolean rowInserted = ps.executeUpdate() > 0;
        ps.close();
        connectData.disconnect();
        return rowInserted;
    }

    public List<Department> listAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();

        String sql = "SELECT * FROM departments";
        connectData.connect();

        Statement statement = connectData.getJdbcConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            String departmentName = rs.getString("department_name");
            Department department = new Department();
            department.setDepartmentName(departmentName);
            departments.add(department);
        }

        rs.close();
        statement.close();
        connectData.disconnect();
        return departments;
    }

    public boolean deleteDepartment(Department department) throws SQLException {
        String sql = "DELETE FROM departments WHERE department_name = ?";
        connectData.connect();

        PreparedStatement ps = connectData.getJdbcConnection().prepareStatement(sql);
        ps.setString(1, department.getDepartmentName());

        boolean rowDeleted = ps.executeUpdate() > 0;
        ps.close();
        connectData.disconnect();
        return rowDeleted;
    }
}
