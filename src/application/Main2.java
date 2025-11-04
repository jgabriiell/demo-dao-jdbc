package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: department findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("=== Test 1: department findAll ===");
        List<Department> departmentList = departmentDao.findAll();
        System.out.println(departmentList);
    }
}
