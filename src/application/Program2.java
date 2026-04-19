package application;

import model.dao.DaoFactory;
import model.entities.Department;
import model.dao.DepartmentDao;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("==== Department insert ====");
        Department department = new Department(null, "Variables");
        departmentDao.insert(department);
        System.out.println("Inserted! new Id = " + department.getId());

        System.out.println("==== Department update ====");
        department = departmentDao.findById(5);
        department.setName("Comestics");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("==== Department delete ====");
        System.out.print("Enter de id for delete: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete Completed");

        System.out.println("==== Department FindById ====");
        department = departmentDao.findById(6);
        System.out.println(department);

        System.out.println("==== Department FindAll");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }

        sc.close();

    }
}
