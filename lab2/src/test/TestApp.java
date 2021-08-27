package test;

import model.*;
import store.ProductStore;
import store.WoodDirectory;

public class TestApp {

    private WoodDirectory wd = new WoodDirectory();

    private ProductStore ps = new ProductStore();

    public void startApp() {
        wd.add(new Wood(0,"Береза",2.7f));
        wd.add(new Wood(1,"Яблуня",1.2f));
        wd.add(new Wood(2,"Сосна", 4.5f));
        ps.add(new Timber(wd.get(0),7f,0.5f,0.4f));
        ps.add(new Timber(wd.get(1),10f,0.5f,0.4f));
        ps.add(new Cylinder((wd.get(1)),11f,22f));
        ps.add(new Waste(4.3f));
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
