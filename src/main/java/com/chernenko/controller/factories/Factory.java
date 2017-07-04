package com.chernenko.controller.factories;

import com.chernenko.controller.MainController;
import com.chernenko.controller.abstractFactory.AbstractFactory;
import com.chernenko.controller.factories.department.ActionDepartment;
import com.chernenko.controller.factories.department.impl.CreateDepartment;
import com.chernenko.controller.factories.department.impl.DeleteDepartment;
import com.chernenko.controller.factories.department.impl.InsertDepartment;
import com.chernenko.controller.factories.department.impl.ListDepartments;
import com.chernenko.controller.factories.employee.ActionEmployee;
import com.chernenko.controller.factories.employee.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton on 29.05.2017.
 */
public class Factory extends AbstractFactory {

    private Map<Enum, MainController> map = new HashMap<>();

    {
        map.put(ActionDepartment.createDepartment, new CreateDepartment());
        map.put(ActionDepartment.insertDepartment, new InsertDepartment());
        map.put(ActionDepartment.deleteDepartment, new DeleteDepartment());
        map.put(ActionDepartment.listDepartments, new ListDepartments());
        map.put(ActionEmployee.createEmployee, new CreateEmployee());
        map.put(ActionEmployee.insertEmployee, new InsertEmployee());
        map.put(ActionEmployee.deleteEmployee, new DeleteEmployee());
        map.put(ActionEmployee.changeEmployee, new ChangeEmployee());
        map.put(ActionEmployee.updateEmployee, new InsertEmployee());
        map.put(ActionEmployee.listEmployees, new GetEmployeeByDepartmentName());
    }

    @Override
    public MainController getController(String url) {
        MainController controller = null;
        for (Map.Entry<Enum, MainController> entry : map.entrySet()) {
            if (entry.getKey().toString().equals(url)) {
                controller = entry.getValue();
                break;
            }
        }
        return controller;
    }
}
