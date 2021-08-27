package main;

import test.TestApp;
import test.TestByConsole;
import test.TestCollections;

public class main {
    public static void main(String[] args) throws Exception {
        TestApp app = new TestApp();
        app.startApp();
        TestByConsole consoleApp = new TestByConsole();
        consoleApp.startAppConsole();
        TestCollections testCol = new TestCollections();
        testCol.main();
    }
}
