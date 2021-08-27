package test;

import model.*;
import store.ProductStore;
import store.WoodDirectory;

import javax.swing.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
import javax.swing.filechooser.FileFilter;

public class TestByConsole implements java.io.Serializable{
    private WoodDirectory NewDirectory = new WoodDirectory();
    private ProductStore NewStore = new ProductStore();
    Scanner input = new Scanner(System.in);
    private final BufferedWriter bw = new BufferedWriter(new FileWriter("Log.TXT",true));

    public TestByConsole() throws IOException {
    }

    public void startAppConsole() throws Exception {
        Name();

        while(true) {
            System.out.println("\n1 - Додати деревину");
            System.out.println("2 - Додати брус");
            System.out.println("3 - Підрахувати загальну вагу");
            System.out.println("4 - Завершити роботу");
            System.out.println("5 - Додати циліндр");
            System.out.println("6 - Додати відходи");
            System.out.println("7 - Зберегти");
            System.out.println("8 - Експортувати у текстовий файл");

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
                    bw.close();
                    return;
                case 5:
                    AddCylinder();
                    break;
                case 6:
                    AddWaste();
                    break;
                case 7:
                    Serialization();
                    Deserialization();
                    break;
                case 8:
                    ToTXTFile();
                    break;
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

    private void AddTimber() throws Exception {
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

    private void AddCylinder() throws Exception {
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

    private void AddWaste() throws Exception {
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

    private void Serialization (){
        //Збереження WoodDirectory у файлі
        File f = new File("wd.object");
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(NewDirectory);
            oos.close();
        }catch (Exception e ){
            e.printStackTrace();
        }
        //Збереження ProductStore у файлі
        File ff = new File("ps.object");
        try{
            FileOutputStream fos1 = new FileOutputStream(ff);
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(NewStore);
            oos1.close();
        }catch (Exception e ) {
            e.printStackTrace();
        }

    }

    private void Deserialization () {
        //Відновлення WoodDirecroty з файлу
        File f = new File("wd.object");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            NewDirectory = (WoodDirectory) ois.readObject();
            ois.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        //Виведення WoodDirecroty на консоль
        if (NewDirectory != null){
            for (Object w: NewDirectory.getArr())
                System.out.println(w.toString());
        }

        //Відновлення ProductStore з файлу
        File ff = new File("ps.object");
        try{
            FileInputStream fis1 = new FileInputStream(ff);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            NewStore = (ProductStore) ois1.readObject();
            ois1.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        //Виведення ProductStore на консоль
        if (NewStore != null){
            for (Object w: NewStore.getArr())
                System.out.println(w.toString());
        }
    }

    private void ToTXTFile(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFileChooser dialog = new JFileChooser();
        dialog.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f!= null){
                    //Відображати усі папки та файли .txt
                    return f.isDirectory() || f.toString().endsWith(".txt");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "файли типу *.txt";
            }
        });
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.setDialogTitle("Виберіть потрібні файли і папки");
        dialog.setApproveButtonText("Open");
        dialog.setMultiSelectionEnabled(true);
        dialog.showSaveDialog(null);
        File [] ff= dialog.getSelectedFiles();
        if(ff!=null) {
            for (File f : ff) {
                System.out.println(f.getAbsolutePath());
                //формування текстового файлу з каталогом деревини та виробів
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(f));
                    writer.write(NewDirectory.toString());
                    writer.newLine();
                    writer.write(NewStore.toString());
                    writer.close();
                    System.out.println("Файл збережено");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void WriteString(String s){
        try {
            bw.write((new Date()) + " added " + s);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Name(){
        System.out.println("Введіть ваше ім'я та прізвище");
        String s = input.nextLine();
        try{
            bw.write((new Date())+ " " + s + " logged in");
            bw.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
