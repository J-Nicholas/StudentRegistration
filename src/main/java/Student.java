import org.joda.time.*;

import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private DateTime dateOfBirth;
    private int id;
    private String userName;
    private ArrayList<Course> enrolledCourses;

    public Student(String firstName, String lastName, DateTime dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.id = IDNumberFactory.getNextID();
        generateUsername();
        enrolledCourses = new ArrayList<Course>();
    }

    private void generateUsername() {
        if (!getFullName().equals("") && null != dateOfBirth) {
            this.userName = getFullName()
                    .concat(dateOfBirth.dayOfMonth().toString() +
                            dateOfBirth.monthOfYear() +
                            dateOfBirth.year());
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

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public boolean enrollInCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            System.out.println("Already enrolled in course: " + course.getTitle());
            return false;
        }
        else {
            enrolledCourses.add(course);
            return true;
        }
    }

    public boolean disEnrollInCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            enrolledCourses.remove(course);
            return true;
        }
        else {
            System.out.println("Did not find course: " + course.getTitle());
            return false;
        }
    }
}
