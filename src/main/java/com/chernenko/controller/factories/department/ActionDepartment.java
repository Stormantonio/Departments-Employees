package com.chernenko.controller.factories.department;

/**
 * Created by Anton on 16.04.2017.
 */
public enum ActionDepartment {

    createDepartment {
        public
        @Override
        String toString() {
            return "http://localhost:8088/createDepartment";
        }
    },

    listDepartments {
        public

        @Override
        String toString() {
            return "http://localhost:8088/";
        }
    },

    deleteDepartment {
        public

        @Override
        String toString() {
            return "http://localhost:8088/deleteDepartment";
        }
    },

    insertDepartment {
        public

        @Override
        String toString() {
            return "http://localhost:8088/insertDepartment";
        }
    }
}
