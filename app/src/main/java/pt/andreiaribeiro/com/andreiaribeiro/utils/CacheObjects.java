package pt.andreiaribeiro.com.andreiaribeiro.utils;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Rui on 27/09/2017.
 */

public class CacheObjects {

    public void cacheObject(Context context, String filename, Object object) {
        File myfile = context.getFileStreamPath(filename);
        try {
            if (myfile.exists() || myfile.createNewFile()) {
                FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getCacheObject(Context context, String filename) throws Exception {
        try {
            FileInputStream fis = context.openFileInput(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new Exception();
        }
    }
}
