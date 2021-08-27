package test;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class TestFile {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFileChooser dialog = new JFileChooser();

        dialog.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f != null) {
                    return f.isDirectory() || f.toString().endsWith(".txt");
                    //Вiдображати усi папки та файли .txt
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "Файли типу *.txt";
            }
        });
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.setDialogTitle("Зав'ялов Д.С. КН-19");
        dialog.setApproveButtonText("Вiдкрити");
        dialog.setMultiSelectionEnabled(true);
        dialog.showOpenDialog(null);

        File[] ff = dialog.getSelectedFiles();

        if (ff != null) {
            for (File f : ff) {
                System.out.println(f.getAbsolutePath());
                //формування текстового файлу з числами
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(f));
                    for (int i = 0; i < 10; i++) {
                        double x = Math.random();
                        String s = String.valueOf(x);
                        writer.write(s);
                        writer.newLine();
                    }
                    writer.write("Зав'ялов Д.С. КН-19");
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BufferedReader reader = null;
                if(f != null) {
                    try{
                        reader = new BufferedReader(new FileReader(f));
                        String s;
                        while((s = reader.readLine()) != null) {
                            System.out.println(s);
                        }
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
