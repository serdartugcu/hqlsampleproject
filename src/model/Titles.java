package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by serdartugcu on 17.03.2018.
 */
@Entity
@IdClass(TitlesPK.class)
public class Titles {
    private Integer empNo;
    private String title;
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
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "to_date", nullable = true, insertable = true, updatable = true)
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

        Titles titles = (Titles) o;

        if (empNo != null ? !empNo.equals(titles.empNo) : titles.empNo != null) return false;
        if (title != null ? !title.equals(titles.title) : titles.title != null) return false;
        if (fromDate != null ? !fromDate.equals(titles.fromDate) : titles.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(titles.toDate) : titles.toDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empNo != null ? empNo.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        return result;
    }
}
