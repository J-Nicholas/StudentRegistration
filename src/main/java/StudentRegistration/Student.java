package StudentRegistration;

import org.joda.time.*;

import java.util.ArrayList;

public class Student implements ICourseRegistrar, IModuleRegistrar{
    private String firstName;
    private String lastName;
    private DateTime dateOfBirth;
    private int id;
    private String userName;
    private final Registrar<Course> enrolledCourses;
    private final Registrar<Module> enrolledModules;

    public Student(String firstName, String lastName, DateTime dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.id = IDNumberFactory.getNextID();
        generateUsername();
        enrolledCourses = new Registrar<Course>();
        enrolledModules = new Registrar<Module>();
    }

    private void generateUsername() {
        if (!getFullName().equals("") && null != dateOfBirth) {
            int day = dateOfBirth.dayOfMonth().get();
            String formattedDay = day < 10 ? "0" + day : String.valueOf(day);
            int month = dateOfBirth.monthOfYear().get();
            String formattedMonth = month < 10 ? "0" + month : String.valueOf(month);

            this.userName = firstName + lastName
                    .concat(formattedDay +
                            formattedMonth +
                            dateOfBirth.year().get());
        }
        else System.out.println("Error generating username");
    }

    public String getFullName() {
        if (null != firstName && null != lastName) {
            return firstName + " " + lastName;
        } else return "";
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Course> getCourses() {
        return enrolledCourses.get();
    }

    public void setCourses(ArrayList<Course> courses) {
        this.enrolledCourses.set(courses);
    }

    public ArrayList<Module> getModules() {
        return enrolledModules.get();
    }

    public void setModules(ArrayList<Module> associatedModules) {
        enrolledModules.set(associatedModules);
    }

    public boolean enrollInCourse(Course course) {
        return enrolledCourses.add(course) && course.getRegisteredStudents().add(this);
    }

    public boolean disEnrollInCourse(Course course) {
        return  enrolledCourses.remove(course) && course.getRegisteredStudents().remove(this) ;
    }

    public boolean enrollInModule(Module module) {
        return enrolledModules.add(module)  && module.getRegisteredStudents().add(this);
    }

    public boolean disEnrollModule(Module module) {
        return enrolledModules.remove(module)  && module.getRegisteredStudents().remove(this);
    }

    @Override
    public String toString() {
        return getFullName();
    }


}
