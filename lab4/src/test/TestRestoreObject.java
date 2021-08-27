package test;

import store.WoodDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestRestoreObject {
    public static void main(String[] args) {
        WoodDirectory wd = null;
        File f = new File("wd.object");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            wd = (WoodDirectory) ois.readObject();
            ois.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (wd != null) {
            for(Object w : wd.getArr())
                System.out.println(w.toString());
        }
    }
}
