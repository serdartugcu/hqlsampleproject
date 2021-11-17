import dao.HibernateUtil;
import model.Employees;
import model.Salaries;
import service.EmployeesService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by serdartugcu on 17.03.2018.
 */
public class Main {

    public static void main(String[] args) {

        List<Employees> empSalary = new EmployeesService().getEmployeeSalary(100002);
        if(empSalary.size() > 0) {
            Employees e = empSalary.get(0);
            for(Salaries s:e.getSalaries()) {
                System.out.println("empNo: " + e.getEmpNo() + " First Name: " + e.getFirstName() +
                        " Last Name: " + e.getLastName() + " Salary: " + s.getSalary() + " From: " + s.getFromDate() +
                        " To: " + s.getToDate());
            }
        }

    }
}

