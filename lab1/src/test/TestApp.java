package test;

import model.Timber;
import store.ProductStore;
import store.WoodDirectory;

public class TestApp {

    private WoodDirectory wd = new WoodDirectory();

    private ProductStore ps = new ProductStore();

    public void startApp() {
        ps.add(new Timber(wd.get(0),5f,0.5f,0.4f));
        ps.add(new Timber(wd.get(1),10f,0.5f,0.4f));
        System.out.println(wd);
        System.out.println(ps);
        System.out.printf("Загальна вага: %5.3f", calcWeight());
    }

    private float calcWeight() {
        float fullWeight = 0;
        for(Timber timber : ps.getArr()) {
            fullWeight+=timber.weight();
        }
        return fullWeight;
    }
}
