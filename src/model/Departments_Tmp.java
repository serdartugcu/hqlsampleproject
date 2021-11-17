package model;


import javax.persistence.*;

/**
 * Created by serdartugcu on 17.03.2018.
 */
@Entity
@Table(name = "departments_tmp")
public class Departments_Tmp {
    private String deptNo;
    private String deptName;

    @Id
    @Column(name = "dept_no", nullable = false, insertable = true, updatable = true, length = 4)
    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Basic
    @Column(name = "dept_name", nullable = false, insertable = true, updatable = true, length = 40)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departments_Tmp that = (Departments_Tmp) o;

        if (deptNo != null ? !deptNo.equals(that.deptNo) : that.deptNo != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptNo != null ? deptNo.hashCode() : 0;
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Departments_Tmp{" +
                "deptNo='" + deptNo + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
