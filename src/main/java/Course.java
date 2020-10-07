import java.util.ArrayList;

public class Course {
    private String title;
    private ArrayList<Module> modules;

    public Course(String title) {
        this.title = title;
        modules = new ArrayList<Module>();
    }

    public Course(String title, ArrayList<Module> modules) {
        this(title);
        this.modules = modules;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public boolean addModule(Module module) {
        if (modules.contains(module)) {
            System.out.println("Course already contains module: " + module.getTitle());
            return false;
        }
        else {
            modules.add(module);
            return true;
        }
    }

    public boolean removeModule(Module module) {
        if (modules.contains(module)) {
            modules.remove(module);
            return true;
        }
        else return false;
    }
}
