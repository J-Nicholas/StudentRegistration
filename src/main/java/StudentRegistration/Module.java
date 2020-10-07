package StudentRegistration;

import java.util.ArrayList;

public class Module implements IStudentRegistrar, ICourseRegistrar{
    private String title;
    private String code;
    private final Registrar<Student> registeredStudents;
    private final Registrar<Course> associatedCourses;

    public Module(String title, String code) {
        this.title = title;
        this.code = code;
        registeredStudents = new Registrar<Student>();
        associatedCourses = new Registrar<Course>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Student> getRegisteredStudents() {
        return registeredStudents.get();
    }

    public void setRegisteredStudents(ArrayList<Student> students) {
        this.registeredStudents.set(students);
    }

    public ArrayList<Course> getCourses() {
        return associatedCourses.get();
    }

    public void setCourses(ArrayList<Course> associatedCourses) {
        this.associatedCourses.set(associatedCourses);
    }

    @Override
    public String toString() {
        return title;
    }
}
