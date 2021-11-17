package service;

import dao.EmployeesDao;
import model.Employees;

import java.util.List;

/**
 * Created by serdartugcu on 31.03.2018.
 */
public class EmployeesService {
    public Employees getEmployee(Integer empNo) {
        EmployeesDao employeesDao = new EmployeesDao();
        return employeesDao.getEmployee(empNo);
    }

    public List<Employees> getEmployeeList(int min, int max) {
        EmployeesDao employeesDao = new EmployeesDao();
        return employeesDao.getEmployeeList(min, max);
    }

    public List<Employees> getEmployeeSalary(int empNo) {
        EmployeesDao employeesDao = new EmployeesDao();
        return employeesDao.getEmployeesSalary(empNo);
    }

    public List<Object[]> getEmployeeSalaryLeftJoin(int empNo) {
        EmployeesDao employeesDao = new EmployeesDao();
        return employeesDao.getEmployeesSalaryLeftJoin(empNo);
    }

    public List<Object[]> getEmployeeSalaryRightJoin(int empNo) {
        EmployeesDao employeesDao = new EmployeesDao();
        return employeesDao.getEmployeeSalaryRightJoin(empNo);
    }

    public List<Employees> getEmployeesByName(String firstName) {
        EmployeesDao employeesDao = new EmployeesDao();
        return employeesDao.getEmployeesByName(firstName);
    }

    public List<String> getLastNameFromFirstName(String firstName) {
        EmployeesDao employeesDao = new EmployeesDao();
        return employeesDao.getLastNameFromFirstName(firstName);
    }

    public List<Object[]> getBasicInfoFromFirstName(String firstName) {
        EmployeesDao employeesDao = new EmployeesDao();
        return employeesDao.getBasicInfoFromFirstName(firstName);
    }


}
