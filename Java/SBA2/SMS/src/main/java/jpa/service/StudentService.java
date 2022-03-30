package jpa.service;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.mainrunner.SMSRunner;
import org.hibernate.*;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentDAO {
    public List<Student> getAllStudents() {
        // This method reads the student table in your database and returns the data as a List<Student>.
        // This method also displays student information.
        List<Student> students;
        Session s = SMSRunner.getFactory().openSession();

        TypedQuery q = s.getNamedQuery("AllStudents");
        students = q.getResultList();

        System.out.println();
        System.out.println("Here is a list of all students:");
        System.out.format("%-51s%-51s%-51s%n", "Student Email", "Student Name", "Student Password");
        for (Student student : students) {
            System.out.format("%-51s%-51s%-51s%n", student.getsEmail(), student.getsName(), student.getsPass());
        }

        s.close();

        return students;
    }

    public Student getStudentByEmail(String sEmail) {
        // This method takes a Student’s email as a String and parses the student list for a Student with that email.
        // This method returns a Student Object.
        Student student;
        Session s = SMSRunner.getFactory().openSession();

        // get student data using specified email
        TypedQuery q = s.getNamedQuery("StudentByEmail");
        q.setParameter("email", sEmail);
        List<Student> matchingStudent = q.getResultList();
        student = matchingStudent.get(0);

        s.close();

        // return required student data
        return student;
    }

    public boolean validateStudent(String sEmail, String sPassword) {
        // This method takes two parameters: the first one is the user email and the second one is the password
        // from the user input.
        // This method return true if a student with specified credentials was found and false if not.
        boolean validStudent;
        String ePassword;
        Session s = SMSRunner.getFactory().openSession();
        List<Student> students;

        // get student data using specified email
        TypedQuery q = s.getNamedQuery("StudentByEmail");
        q.setParameter("email", sEmail);
        students = q.getResultList();
        if (students.size() == 0) {
            // specified email not found in database, so return false
            return false;
        }
        else {
            // specified email found in database, so get password and compare with specified password
            ePassword = students.get(0).getsPass();
            validStudent = sPassword.equals(ePassword);
        }
        s.close();

        // return validation status
        return validStudent;
    }

    public void registerStudentToCourse(String sEmail, int cId) {
        // This method takes a Student’s email and a Course ID and checks in the join table (i.e. Student_Course)
        // if a student with specified email is currently registered for a course with specified ID.
        // If the student is not registered for that course, the method registers the student for that course.
        Course newCourse;
        Session s = SMSRunner.getFactory().openSession();
        Transaction t = s.beginTransaction();

        // check if specified email and specified course id are a row in join table
        TypedQuery q = s.createSQLQuery("SELECT COUNT(*) FROM Student_Course WHERE semail = :email AND cid = :cid");
        q.setParameter("email", sEmail);
        q.setParameter("cid", cId);
        BigInteger count = (BigInteger) q.getSingleResult();
        if (count.intValue() == 0L) {
            // specified email not registered for course id, so register email for course id

            // get existing courses for email
            List<Course> uCourseList = getStudentCourses(sEmail);

            // get the course with the specified course id
            q = s.getNamedQuery("CourseByID");
            q.setParameter("id", cId);
            List<Course> matchingCourse = q.getResultList();
            if (matchingCourse.size() == 0) {
                // invalid course ID (not in database)
                System.out.println();
                System.out.println("There is no course with ID " + cId);
            } else {
                // valid course ID (in database), add this course to existing course list
                newCourse = matchingCourse.get(0);
                uCourseList.add((newCourse));

                // get existing student object
                Student uStudent = getStudentByEmail(sEmail);

                // update student object's course list
                uStudent.setCourseList(uCourseList);

                // update student record
                s.update(uStudent);
                t.commit();

                // display courses that student is now registered for
                List<Course> c = getStudentCourses(sEmail);
            }
        } else {
            // specified email already registered, so display message
            System.out.println();
            System.out.println("You are already registered for this course.");
        }
        s.close();
    }

    public List<Course> getStudentCourses(String sEmail) {
        // This method returns a list of all courses a student is registered for.
        List<Course> courseList= new ArrayList<>();
        Session s = SMSRunner.getFactory().openSession();

        // get all course ids for specified email from join table
        TypedQuery q = s.createSQLQuery("SELECT cid FROM Student_Course WHERE semail = :email");
        q.setParameter("email", sEmail);
        List<Integer> results = q.getResultList();
        if (results.size() != 0) {
            // email is signed up for at least one course
            List<Integer> courseIDList = new ArrayList<>(results);

            // get course object for each course id for specified email
            q = s.getNamedQuery("CourseByID");
            for (Integer cId : courseIDList) {
                q.setParameter("id", cId);
                Course course = (Course) q.getSingleResult();
                courseList.add(course);
            }
        }

        s.close();

        System.out.println();
        if (courseList.size() == 0) {
            System.out.println();
            System.out.println("You are not registered for any courses yet.");
        }
        else {
            System.out.println();
            System.out.println("You are registered for the following courses:");
            System.out.format("%-5s%-51s%-51s%n", "ID", "Course Name", "Instructor Name");
            for (Course r: courseList) {
                System.out.format("%-5d%-51s%-51s%n", r.getcId(), r.getcName(), r.getcInstructorName());
            }
        }

        return courseList;
    }
}
