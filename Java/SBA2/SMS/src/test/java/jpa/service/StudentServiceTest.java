package jpa.service;

import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import javax.persistence.TypedQuery;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    static SessionFactory f;
    static Session s;
    static StudentService ss;
    @BeforeAll
    static void setUp() {
        f = new Configuration().configure().buildSessionFactory();
        s = f.openSession();
        ss = new StudentService();
    }

    @AfterAll
    static void tearDown() {
        s.close();
        f.close();
    }

    @ParameterizedTest
    @CsvSource({
            "hluckham0@google.ru, X1uZcoIh0dj",         // valid email and valid password
            "user@gmail.com, up123",                    // valid email and valid password
            "qllorens2@howstuffworks.com, wrong123",    // valid email and invalid password
            "invaliduser@gmail.com, FnVklVgC6r6",       // invalid email and existing password
            "another@gmail.com, an123"                  // invalid email and invalid password
    })
    void testValidateStudent(String email, String password) {
        // get return value from the method we are testing
        boolean actualValidStudent = ss.validateStudent(email, password);

        // get the value on our own
        boolean expectedValidStudent;
        TypedQuery q = s.createQuery("FROM Student s WHERE s.sEmail = :email");
        q.setParameter("email", email);
        List<Student> actualResult = q.getResultList();
        if (actualResult.size() == 1) {
            // we only expect one row for one email/user
            String actualPassword = actualResult.get(0).getsPass();
            expectedValidStudent = password.equals(actualPassword);
        }
        else {
            // email not found, so invalid email
            expectedValidStudent = false;
        }

        // compare the two values
        assertEquals(expectedValidStudent, actualValidStudent);
    }
}