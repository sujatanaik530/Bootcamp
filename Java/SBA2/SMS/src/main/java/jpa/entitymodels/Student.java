package jpa.entitymodels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Student")
@NamedQueries(
        {
                @NamedQuery( name = "AllStudents", query = "FROM Student s"),
                @NamedQuery( name = "StudentByEmail", query = "SELECT s FROM Student s WHERE s.sEmail = :email")
        }
)
public class Student {
    @Id
    @Column (name = "email", unique = true, nullable = false, length = 50)
    private String sEmail;

    @Column (name = "name", nullable = false, length = 50)
    private String sName;

    @Column (name = "password", nullable = false, length = 50)
    private String sPass;

    @ManyToMany (targetEntity = Course.class, cascade = CascadeType.ALL)
    @JoinTable (name = "Student_Course",
                joinColumns = {@JoinColumn(name = "semail")},
                inverseJoinColumns = {@JoinColumn(name = "cid")})
    private List<Course> courseList;

    public Student() {
    }

    public Student(String sEmail, String sName, String sPass, List<Course> courseList) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.courseList = courseList;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
