package jpa.entitymodels;

import javax.persistence.*;

@Entity
@Table (name = "Course")
@NamedQueries(
        {
                @NamedQuery( name = "CourseByID", query = "SELECT c FROM Course c WHERE id = :id"),
                @NamedQuery( name = "AllCourses", query = "FROM Course c")
        }
)
public class Course {
    @Id
    @Column (name = "id", unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int cId;

    @Column (name = "name", nullable = false, length = 50)
    private String cName;

    @Column (name = "Instructor", nullable = false, length = 50)
    private String cInstructorName;

    public Course() {
    }

    public Course(String cName, String cInstructorName) {
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }
}
