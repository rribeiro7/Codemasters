package pt.andreiaribeiro.com.andreiaribeiro.mocks;

/**
 * Created by Rui on 23/11/2017.
 */

public class ObjSpinner {
    private String name;
    private int id;

    public ObjSpinner(int idObj, String nameObj) {
        name = nameObj;
        id = idObj;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString()
    {
        return name;
    }
}