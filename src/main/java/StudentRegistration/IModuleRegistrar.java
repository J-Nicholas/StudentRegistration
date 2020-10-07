package StudentRegistration;

import java.util.ArrayList;

public interface IModuleRegistrar {
    ArrayList<Module> getModules();
    void setModules(ArrayList<Module> associatedModules);
}
