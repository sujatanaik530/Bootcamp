package com.perscholas.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class Teacher implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "teacher_id_PK")
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int tit;
    private String salary;
    private String Teachername;

    // Create the relationship
    @ManyToOne
    @JoinColumn(name = "department_id_FK") // name of foreign key column (by default dept_did)
    private Department dept;

    public Teacher(int tit, String salary, String teachername, Department dept) {
        this.tit = tit;
        this.salary = salary;
        this.Teachername = teachername;
        this.dept = dept;
    }

    public Teacher()
    {}

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public int getTit() {
        return tit;
    }

    public void setTit(int tit) {
        this.tit = tit;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTeachername() {
        return Teachername;
    }

    public void setTeachername(String teachername) {
        Teachername = teachername;
    }
}
