package dao;

import model.Employees;
import model.Salaries;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;


/**
 * Created by serdartugcu on 31.03.2018.
 */
public class EmployeesDao {
    public Employees getEmployee(Integer empNo) {
        Session session = HibernateUtil.getSession();
        String hql = "from Employees e where e.empNo = :empNo";
        Query query = session.createQuery(hql);
        query.setParameter("empNo", empNo);
        Employees employees = (Employees) query.uniqueResult();
        return employees;
    }

    public List<Employees> getEmployeeList(int min, int max) {
        Session session = HibernateUtil.getSession();
        String hql = "from Employees";
        Query query = session.createQuery(hql);
        query.setFirstResult(min);
        query.setMaxResults(max);
        List<Employees> employeesList = query.list();
        return employeesList;
    }

    public List<Employees> getEmployeesSalary(int empNo) {
        CriteriaBuilder builder = HibernateUtil.getSession().getCriteriaBuilder();
        CriteriaQuery<Employees> criteria = builder.createQuery( Employees.class );
        Root<Employees> root = criteria.from( Employees.class );

        Join<Employees, Salaries> employeeJoin = root.join( "salaries");

        criteria.where(builder.equal(root.get("empNo"), empNo));

        List<Employees> resultList = HibernateUtil.getSession().createQuery( criteria ).getResultList();
        return resultList;

//        Session session = HibernateUtil.getSession();
//        String hql = "select e.empNo, e.firstName, e.lastName, s.salary, s.fromDate, s.toDate from Employees e inner join e.salaries s where e.empNo = :empNo";
//        Query query = session.createQuery(hql);
//        query.setParameter("empNo", empNo);
//        return  query.list();
    }

    public List<Object[]> getEmployeesSalaryLeftJoin(int empNo) {
        Session session = HibernateUtil.getSession();
        String hql = "select e.empNo, e.firstName, e.lastName, s.salary, s.fromDate, s.toDate from Employees e left join e.salaries s where e.empNo = :empNo";
        Query query = session.createQuery(hql);
        query.setParameter("empNo", empNo);
        return query.list();
    }

    public List<Object[]> getEmployeeSalaryRightJoin(int empNo) {
        Session session = HibernateUtil.getSession();
        String hql = "select e.empNo, e.firstName, e.lastName, s.salary, s.fromDate, s.toDate from Employees e right join e.salaries s where s.empNo = :empNo";
        Query query = session.createQuery(hql);
        query.setParameter("empNo", empNo);
        return query.list();
    }

    public List<Employees> getEmployeesByName(String firstName) {

        CriteriaBuilder builder = HibernateUtil.getSession().getCriteriaBuilder();

        CriteriaQuery<Employees> criteria = builder.createQuery( Employees.class );
        Root< Employees > root = criteria.from(Employees.class );
        criteria.where( builder.equal( root.get("firstName"), firstName ) );

        List<Employees> employees = HibernateUtil.getSession().createQuery(criteria).getResultList();
        return employees;
    }

    public List<String> getLastNameFromFirstName(String firstName) {
        CriteriaBuilder builder = HibernateUtil.getSession().getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        Root<Employees> root = criteria.from(Employees.class);
        criteria.select(root.get("lastName"));
        criteria.where(builder.equal(root.get("firstName"), firstName));
        return HibernateUtil.getSession().createQuery(criteria).getResultList();
    }

    public List<Object[]> getBasicInfoFromFirstName(String firstName) {
        CriteriaBuilder builder = HibernateUtil.getSession().getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery( Object[].class );
        Root<Employees> root = criteria.from( Employees.class );
        Path<Integer> empNo = root.get("empNo");
        Path<String> firstNameString = root.get("firstName");
        Path<String> lastNameString = root.get("lastName");

        criteria.select( builder.array( empNo, firstNameString,lastNameString ) );
        criteria.where( builder.equal( root.get( "firstName"), firstName ) );

        return HibernateUtil.getSession().createQuery( criteria ).getResultList();
    }



}
