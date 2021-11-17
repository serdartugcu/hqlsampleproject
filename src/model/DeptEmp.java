package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by serdartugcu on 17.03.2018.
 */
@Entity
@Table(name = "dept_emp", schema = "", catalog = "employees")
@IdClass(DeptEmpPK.class)
public class DeptEmp {
    private Integer empNo;
    private String deptNo;
    private Date fromDate;
    private Date toDate;

    @Id
    @Column(name = "emp_no", nullable = false, insertable = true, updatable = true)
    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    @Id
    @Column(name = "dept_no", nullable = false, insertable = true, updatable = true, length = 4)
    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Basic
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

        DeptEmp deptEmp = (DeptEmp) o;

        if (empNo != null ? !empNo.equals(deptEmp.empNo) : deptEmp.empNo != null) return false;
        if (deptNo != null ? !deptNo.equals(deptEmp.deptNo) : deptEmp.deptNo != null) return false;
        if (fromDate != null ? !fromDate.equals(deptEmp.fromDate) : deptEmp.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(deptEmp.toDate) : deptEmp.toDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empNo != null ? empNo.hashCode() : 0;
        result = 31 * result + (deptNo != null ? deptNo.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        return result;
    }
}
