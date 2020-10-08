package StudentRegistration;

import org.joda.time.DateTime;

import static org.junit.Assert.*;

public class StudentTest {

    Student harry;
    Module softwareEngineering;
    Course computerScience;

    @org.junit.Before
    public void setup() {
        harry = new Student("Harry", "Smith", new DateTime(1993, 8, 1, 0, 0));
        softwareEngineering = new Module("Software Engineering", "CT417");
        computerScience = new Course("Computer Science & IT");
    }

    @org.junit.Test
    public void getFullName() {
        assertEquals("Harry Smith", harry.getFullName());
    }

    @org.junit.Test
    public void getUserName() {
        assertEquals("HarrySmith01081993", harry.getUserName());
    }

    @org.junit.Test
    public void enrollInCourse() {
        assertEquals(0, harry.getCourses().size());
        assertEquals(0, computerScience.getRegisteredStudents().size());
        assertFalse(computerScience.getRegisteredStudents().contains(harry));
        assertFalse(harry.getCourses().contains(computerScience));

        harry.enrollInCourse(computerScience);
        harry.enrollInCourse(computerScience); // multiple calls should only enroll once

        assertEquals(1, harry.getCourses().size());
        assertEquals(1, computerScience.getRegisteredStudents().size());
        assertTrue(computerScience.getRegisteredStudents().contains(harry));
        assertTrue(harry.getCourses().contains(computerScience));

        assertEquals(computerScience, harry.getCourses().get(0));
        assertEquals(harry, computerScience.getRegisteredStudents().get(0));
    }

    @org.junit.Test
    public void disEnrollInCourse() {
        harry.enrollInCourse(computerScience);
        assertTrue(computerScience.getRegisteredStudents().contains(harry));
        assertTrue(harry.getCourses().contains(computerScience));
        assertEquals(1, harry.getCourses().size());

        harry.disEnrollInCourse(computerScience);
        assertEquals(0, harry.getCourses().size());
        assertFalse(harry.getCourses().contains(computerScience));
        assertFalse(computerScience.getRegisteredStudents().contains(harry));
    }

    @org.junit.Test
    public void disEnrollInCourseFalsePositiveCheck() {
        assertFalse(harry.disEnrollInCourse(computerScience));
    }

    @org.junit.Test
    public void enrollInModule() {
        assertEquals(0, harry.getModules().size());
        assertEquals(0, softwareEngineering.getRegisteredStudents().size());
        assertFalse(softwareEngineering.getRegisteredStudents().contains(harry));
        assertFalse(harry.getModules().contains(softwareEngineering));

        harry.enrollInModule(softwareEngineering);
        harry.enrollInModule(softwareEngineering);  // multiple calls should only enroll once
        assertEquals(1, harry.getModules().size());
        assertEquals(1, softwareEngineering.getRegisteredStudents().size());

        assertEquals(softwareEngineering, harry.getModules().get(0));
        assertEquals(harry, softwareEngineering.getRegisteredStudents().get(0));
    }

    @org.junit.Test
    public void disEnrollModule() {
        harry.enrollInModule(softwareEngineering);
        assertEquals(1, harry.getModules().size());
        harry.disEnrollModule(softwareEngineering);
        assertEquals(0, harry.getModules().size());
    }

    @org.junit.Test
    public void disEnrollModuleFalsePositiveCheck() {
        assertFalse(harry.disEnrollModule(softwareEngineering));
    }

}