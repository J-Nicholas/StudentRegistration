package StudentRegistration;
import static org.junit.Assert.*;

public class CourseTest {

    Module softwareEngineering;
    Course computerScience;

    @org.junit.Before
    public void setup() {
        softwareEngineering = new Module("Software Engineering", "CT417");
        computerScience = new Course("Computer Science & IT");
    }

    @org.junit.Test
    public void addModule() {
        assertEquals(0, computerScience.getModules().size());
        assertEquals(0, softwareEngineering.getCourses().size());
        assertFalse(computerScience.getModules().contains(softwareEngineering));
        assertFalse(softwareEngineering.getCourses().contains(computerScience));

        computerScience.addModule(softwareEngineering);
        computerScience.addModule(softwareEngineering); // multiple calls should only allow module to be added once

        assertEquals(0, computerScience.getModules().size());
        assertEquals(1, softwareEngineering.getCourses().size());
        assertTrue(computerScience.getModules().contains(softwareEngineering));
        assertTrue(softwareEngineering.getCourses().contains(computerScience));
    }

    @org.junit.Test
    public void removeModule() {
        computerScience.addModule(softwareEngineering);
        assertEquals(1, computerScience.getModules().size());
        assertEquals(1, softwareEngineering.getCourses().size());

        computerScience.removeModule(softwareEngineering);
        assertEquals(0, softwareEngineering.getCourses().size());
        assertEquals(0, computerScience.getModules().size());
    }
}