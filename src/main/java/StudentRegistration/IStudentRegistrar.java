package StudentRegistration;

import java.util.ArrayList;

public interface IStudentRegistrar {

    ArrayList<Student> getRegisteredStudents();
    void setRegisteredStudents(ArrayList<Student> students);
}
