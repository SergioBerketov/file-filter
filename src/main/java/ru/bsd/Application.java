package ru.bsd;

import ru.bsd.Controller.Controller;
import ru.bsd.Controller.AppController;

public class Application {

    public static void main(String[] args) {
        Controller controller = new AppController();
        controller.run(args);
    }
}