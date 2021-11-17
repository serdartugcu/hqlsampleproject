package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by serdartugcu on 17.03.2018.
 */
@Entity
@IdClass(SalariesPK.class)
public class Salaries {
    private Integer empNo;
    private Integer salary;
    private Date fromDate;
    private Date toDate;

    Employees employees;
    @ManyToOne
    @JoinColumn(name = "emp_no", insertable = false, updatable = false)
    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    @Id
    @Column(name = "emp_no", nullable = false, insertable = true, updatable = true)
    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    @Basic
    @Column(name = "salary", nullable = false, insertable = true, updatable = true)
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Id
    @Column(name = "from_date", nullable = false, insertable = true, updatable = true)
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "to_date", nullable = false, insertable = true, updatable = true)
    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salaries salaries = (Salaries) o;

        if (empNo != null ? !empNo.equals(salaries.empNo) : salaries.empNo != null) return false;
        if (salary != null ? !salary.equals(salaries.salary) : salaries.salary != null) return false;
        if (fromDate != null ? !fromDate.equals(salaries.fromDate) : salaries.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(salaries.toDate) : salaries.toDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empNo != null ? empNo.hashCode() : 0;
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        return result;
    }
}
