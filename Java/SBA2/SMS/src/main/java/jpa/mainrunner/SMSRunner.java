package jpa.mainrunner;

import jpa.entitymodels.Course;
import jpa.service.CourseService;
import jpa.service.StudentService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SMSRunner {
    private static SessionFactory f = null;

    public static SessionFactory getFactory() {
        if (f == null) {
            f = new Configuration().configure().buildSessionFactory();
        }
        return f;
    }

    public static void main(String[] args) {
        try {
            insertRowsIntoDB();
        }
        catch (HibernateException e) {
            System.out.println("Hibernate configuration error");
            System.exit(1);
        }

        boolean goodbye = false;

        while (!goodbye) {
            try {
                // display main menu
                System.out.println("\nMain Menu");
                System.out.println();
                System.out.println("1. View Student Information");
                System.out.println("2. Quit");
                System.out.println();
                Scanner uIn = new Scanner(System.in);
                int uChoice = uIn.nextInt();
                uIn.nextLine();
                switch (uChoice) {
                    case 1: {
                        // view student information

                        // ask for credentials
                        System.out.println();
                        System.out.println("Enter your email: ");
                        String uEmail = uIn.nextLine();
                        System.out.println("Enter your password: ");
                        String uPassword = uIn.nextLine();

                        // validate provided credentials
                        StudentService ss = new StudentService();
                        CourseService cs = new CourseService();
                        boolean validStudent = ss.validateStudent(uEmail, uPassword);
                        if (validStudent) {
                            List<Course> rCourseList = ss.getStudentCourses(uEmail);
                            boolean mainmenu = false;
                            while (!mainmenu) {
                                // credentials validated
                                System.out.println();
                                System.out.println("Student Menu");
                                System.out.println();
                                System.out.println("1. Register for a new course");
                                System.out.println("2. View courses registered for");
                                System.out.println("3. Logout");
                                System.out.println();
                                uChoice = uIn.nextInt();
                                uIn.nextLine();
                                switch (uChoice) {
                                    case 1: {
                                        // register student for a new course
                                        // show course list
                                        List<Course> allCourses = cs.getAllCourses();

                                        // accept course id
                                        System.out.println();
                                        System.out.println("Enter ID of course to register for: ");

                                        try {
                                            int cId = uIn.nextInt();
                                            uIn.nextLine();
                                            // register for course
                                            ss.registerStudentToCourse(uEmail, cId);
                                        }
                                        catch (InputMismatchException e) {
                                            System.out.println("Invalid input for student menu");
                                            uIn.nextLine();
                                        }
                                        finally {
                                            break;
                                        }
                                    }
                                    case 2: {
                                        List<Course> vCourseList = ss.getStudentCourses(uEmail);
                                        break;
                                    }
                                    case 3: {
                                        // log student out
                                        uEmail = "";
                                        uPassword = "";
                                        System.out.println();
                                        System.out.println("Logged out");
                                        mainmenu = true;
                                        break;
                                    }
                                    default: {
                                        // bad choice
                                        System.out.println("Invalid numerical input");
                                        break;
                                    }
                                }
                            }
                        } else {
                            // credentials not validated
                            System.out.println("Wrong Credentials");
                        }
                        break;
                    }

                    case 2: {
                        // quit application after closing SessionFactory
                        f.close();
                        System.out.println();
                        System.out.println("Goodbye!");
                        goodbye = true;
                        break;
                    }
                    default: {
                        // bad choice
                        break;
                    }
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input for main menu");
            }
            catch (HibernateException e) {
                System.out.println("Hibernate exception");
                System.exit(1);
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    private static void insertRowsIntoDB() {
        Session s = getFactory().openSession();
        Transaction t = s.beginTransaction();

        TypedQuery qS = s.createSQLQuery("insert into Student (email, name, password) values (:semail, :sname, :spass)");

        String[][] sRecords = {
                {"hluckham0@google.ru", "Hazel Luckham", "X1uZcoIh0dj"},
                {"sbowden1@yellowbook.com", "Sonnnie Bowden", "SJc4aWSU"},
                {"qllorens2@howstuffworks.com", "Quillan Llorens", "W6rJuxd"},
                {"cstartin3@flickr.com", "Clem Startin", "XYHzJ1S"},
                {"tattwool4@biglobe.ne.jp", "Thornie Attwool", "Hjt0SoVmuBz"},
                {"hguerre5@deviantart.com", "Harcourt Guerre", "OzcxzD1PGs"},
                {"htaffley6@columbia.edu", "Holmes Taffley", "xowtOQ"},
                {"aiannitti7@is.gd", "Alexandra Iannitti", "TWP4hf5j"},
                {"ljiroudek8@sitemeter.com", "Laryssa Jiroudek", "bXRoLUP"},
                {"cjaulme9@bing.com", "Cahra Jaulme", "FnVklVgC6r6"},
                {"user@gmail.com", "Some User", "up123"},
                {"sn@gmail.com", "Sujata Naik", "sn123"}
        };
        for (String[] sRecord : sRecords) {
            qS.setParameter("semail", sRecord[0]);
            qS.setParameter("sname", sRecord[1]);
            qS.setParameter("spass", sRecord[2]);
            qS.executeUpdate();
        }

        TypedQuery qC = s.createSQLQuery("insert into Course (name, instructor) values (:cname, :cinstructor)");
        String[][] cRecords = {
                {"English", "Anderea Scamaden"},
                {"Mathematics", "Eustace Niemetz"},
                {"Anatomy", "Reynolds Pastor"},
                {"Organic Chemistry", "Odessa Belcher"},
                {"Physics", "Dani Swallow"},
                {"Digital Logic", "Glenden Reilingen"},
                {"Object Oriented Programming", "Giselle Ardy"},
                {"Data Structures", "Carolan Stoller"},
                {"Politics", "Carmita De Maine"},
                {"Art", "Kingsly Doxsey"}
        };
        for (String[] cRecord : cRecords) {
            qC.setParameter("cname", cRecord[0]);
            qC.setParameter("cinstructor", cRecord[1]);
            qC.executeUpdate();
        }
        t.commit();
        s.close();
    }
}
