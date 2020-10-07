package StudentRegistration;

import org.joda.time.DateTime;
import java.util.ArrayList;

public class Course implements IStudentRegistrar, IModuleRegistrar {
    private String title;
    private DateTime startDate;
    private DateTime endDate;
    private final Registrar<Module> associatedModules;
    private final Registrar<Student> registeredStudents;

    public Course(String title) {
        this.title = title;
        associatedModules = new Registrar<Module>();
        registeredStudents = new Registrar<Student>();
    }

    public Course(String title, ArrayList<Module> modules) {
        this(title);
        this.associatedModules.set(modules);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Module> getModules() {
        return associatedModules.get();
    }

    public void setModules(ArrayList<Module> associatedModules) {
        this.associatedModules.set(associatedModules);
    }

    public ArrayList<Student> getRegisteredStudents() {
        return registeredStudents.get();
    }

    public void setRegisteredStudents(ArrayList<Student> students) {
        this.registeredStudents.set(students);
    }

    public boolean addModule(Module module) {
        if (null != module) {
            return associatedModules.add(module) && module.getCourses().add(this);
        } else return false;
    }

    public boolean removeModule(Module module) {
        return associatedModules.remove(module) && module.getCourses().remove(this);
    }

    @Override
    public String toString() {
        return title;
    }


}
