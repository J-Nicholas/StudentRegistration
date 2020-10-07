package StudentRegistration;

import java.util.ArrayList;

public class Registrar<T> {

    private ArrayList<T> collection = new ArrayList<T>();

    public boolean add(T object) {
        if (collection.contains(object)) {
            System.out.println( object + " has already been added.");
            return false;
        }
        else {
            collection.add(object);
            return true;
        }
    }

    public boolean remove(T object) {
        if (collection.contains(object)) {
            collection.remove(object);
            return true;
        }
        else {
            System.out.println("Could not find and remove: " + object);
            return false;
        }
    }

    public ArrayList<T> get() {
        return collection;
    }

    public void set(ArrayList<T> object) {
        collection = object;
    }
}
