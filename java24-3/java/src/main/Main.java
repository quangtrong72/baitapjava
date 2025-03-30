package main;

import Controller.MainController;
import View.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame view = new MainFrame();
        new MainController(view);
        view.setVisible(true);
    }
}