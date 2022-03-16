package org.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.*;

import com.perscholas.model.CohortTest;
import com.perscholas.model.TeacherTest;

@RunWith(Suite.class)
@SuiteClasses({CohortTest.class, TeacherTest.class})
public class JUnit5SelectClassTest {

}
