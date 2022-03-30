package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import jpa.mainrunner.SMSRunner;
import org.hibernate.Session;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseService implements CourseDAO {
    public List<Course> getAllCourses() {
        // This method displays and returns a list of every course in the Course table.
        Session s = SMSRunner.getFactory().openSession();

        TypedQuery q = s.getNamedQuery("AllCourses");
        List<Course> courses = q.getResultList();

        s.close();

        System.out.println();
        System.out.println("Here is a list of all offered courses courses: ");
        System.out.format("%-5s%-51s%-51s%n", "ID", "Course Name", "Instructor Name");
        for (Course r : courses) {
            System.out.format("%-5d%-51s%-51s%n", r.getcId(), r.getcName(), r.getcInstructorName());
        }
        return courses;
    }
}
