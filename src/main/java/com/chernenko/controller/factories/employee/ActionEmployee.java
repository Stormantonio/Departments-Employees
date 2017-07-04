package com.chernenko.controller.factories.employee;

/**
 * Created by Anton on 16.04.2017.
 */
public enum ActionEmployee {

    createEmployee {
        public

        @Override
        String toString() {
            return "http://localhost:8088/createEmployee";
        }
    },

    changeEmployee {
        public

        @Override
        String toString() {
            return "http://localhost:8088/changeEmployee";
        }
    },

    updateEmployee {
        public

        @Override
        String toString() {
            return "http://localhost:8088/updateEmployee";
        }
    },

    listEmployees {
        public

        @Override
        String toString() {
            return "http://localhost:8088/listEmployeesByDepartmentName";
        }
    },

    deleteEmployee {
        public

        @Override
        String toString() {
            return "http://localhost:8088/deleteEmployee";
        }
    },

    insertEmployee {
        public

        @Override
        String toString() {
            return "http://localhost:8088/insertEmployee";
        }
    }
}
