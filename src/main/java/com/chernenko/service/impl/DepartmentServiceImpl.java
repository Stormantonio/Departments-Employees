package com.chernenko.service.impl;

import com.chernenko.dao.DepartmentDao;
import com.chernenko.dao.impl.DepartmentDaoImpl;
import com.chernenko.model.Department;
import com.chernenko.service.DepartmentService;
import com.chernenko.util.ConnectData;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Anton on 09.04.2017.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private final String jdbcURL = "jdbc:postgresql://localhost:5432/departments_data";
    private final String jdbcUsername = "postgres";
    private final String jdbcPassword = "0000";

    private ConnectData connectData = new ConnectData(jdbcURL, jdbcUsername, jdbcPassword);

    private DepartmentDao departmentDao = new DepartmentDaoImpl(connectData);

    @Override
    public void insertDepartment(Department department) throws SQLException {
        departmentDao.insertDepartment(department);
    }

    @Override
    public List<Department> listAllDepartments() throws SQLException {
        List<Department> departments = departmentDao.listAllDepartments();
        Collections.sort(departments, (o1, o2) -> o1.getDepartmentName().compareTo(o2.getDepartmentName()));
        return departments;
    }

    @Override
    public void deleteDepartment(Department department) throws SQLException {
        departmentDao.deleteDepartment(department);
    }
}
