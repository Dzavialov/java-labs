package test;

import model.*;
import store.ProductStore;
import store.WoodDirectory;

import javax.swing.*;

public class TestApp {

    private WoodDirectory wd = new WoodDirectory();

    private ProductStore ps = new ProductStore();

    public void startApp() throws Exception {
        wd.add(new Wood(0,"Береза",2.7f));
        wd.add(new Wood(1,"Яблуня",1.2f));
        wd.add(new Wood(2,"Сосна", 4.5f));

        try{
            ps.add(new Waste(50f));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктів",JOptionPane.ERROR_MESSAGE);
        }

        try {
            ps.add(new Timber(wd.get(0),4f,0.2f,0.4f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),
                    "Введення продуктів",JOptionPane.ERROR_MESSAGE);
        }
        try {
            ps.add(new Timber(wd.get(1),10f,0.6f,0.7f ));
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктiв" , JOptionPane.ERROR_MESSAGE);
        }

        try {
            ps.add(new Cylinder(wd.get(2),2f, 0.5f));
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктiв" , JOptionPane.ERROR_MESSAGE);
        }

        System.out.println(wd);
        System.out.println(ps);
        System.out.printf("Загальна вага: %1.3f", calcWeight());


    }

    private float calcWeight() {
        float fullWeight = 0;
        for(Object timber : ps.getArr()) {
            fullWeight+=((IWeight)timber).weight();
        }
        return fullWeight;
    }
}
