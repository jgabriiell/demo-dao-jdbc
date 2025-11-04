package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: department findById ===");
        Department department = departmentDao.findById(8);
        System.out.println(department);

        System.out.println("=== Test 2: department findAll ===");
        List<Department> departmentList = departmentDao.findAll();
        System.out.println(departmentList);

        System.out.println("=== Test 3: department insert ===");
        department = new Department(null, "D3");
        departmentDao.insert(department);
        System.out.println("Insert done! New dep id: " + department.getId());

        System.out.println("=== Test 4: department update ===");
        department.setName("D5");
        departmentDao.update(department);
        System.out.println("Update completed! New dep name: " + department.getName());
    }
}
