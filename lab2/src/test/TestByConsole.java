package test;

import model.*;
import store.ProductStore;
import store.WoodDirectory;

import java.util.Scanner;

public class TestByConsole {
    private WoodDirectory NewDirectory = new WoodDirectory();
    private ProductStore NewStore = new ProductStore();
    Scanner input = new Scanner(System.in);

    public void startAppConsole(){
        while(true) {
            System.out.println("\n1 - Додати деревину");
            System.out.println("2 - Додати брус");
            System.out.println("3 - Підрахувати загальну вагу");
            System.out.println("4 - Завершити роботу");
            System.out.println("5 - Додати циліндр");
            System.out.println("6 - Додати відходи");

            int number = input.nextInt();

            switch (number) {
                case 1:
                    AddWood();
                    break;
                case 2:
                    AddTimber();
                    break;
                case 3:
                    calcWeight();
                    break;
                case 4:
                    return;
                case 5:
                    AddCylinder();
                case 6:
                    AddWaste();
                default:
                    System.out.println("Неправильно введені дані");
                    break;

            }
        }
    }

    private void AddWood() {
        int id = NewDirectory.getArr().length;
        System.out.println("Введіть вид деревини");
        String name = input.next();
        System.out.println("Введіть густоту деревини");
        float density = input.nextFloat();
        Wood w = new Wood(id, name, density);
        NewDirectory.add(w);
        System.out.println(NewDirectory);
    }

    private void AddTimber(){
        System.out.println(NewDirectory);
        System.out.println("Введіть id деревини");
        int id = input.nextInt();
        System.out.println("Введіть довжину бруска");
        float length = input.nextFloat();
        System.out.println("Введіть висоту бруска");
        float height = input.nextFloat();
        System.out.println("Введіть ширину бруска");
        float width = input.nextFloat();
        NewStore.add(new Timber(NewDirectory.get(id),length,height,width));
        id = -1;
    }

    private void AddCylinder(){
        System.out.println(NewDirectory);
        System.out.println("Введіть id деревини");
        int id = input.nextInt();
        System.out.println("Введіть довжину циліндра");
        float length = input.nextFloat();
        System.out.println("Введіть діаметр циліндра");
        float diameter = input.nextFloat();
        NewStore.add(new Cylinder(NewDirectory.get(id), length,diameter));
        System.out.println(NewStore);
        id = -1;
    }

    private void AddWaste(){
        System.out.println("Введіть вагу відходів");
        float weight = input.nextFloat();
        NewStore.add(new Waste(weight));
        System.out.println(NewStore);
    }

    private void calcWeight(){
        float fullWeight = 0;
        for(Object timber : NewStore.getArr()){
            fullWeight += ((IWeight)timber).weight();
        }
        System.out.println("Загальна вага = " + fullWeight);
    }
}
