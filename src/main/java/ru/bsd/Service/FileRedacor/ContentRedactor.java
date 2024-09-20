package ru.bsd.Service.FileRedacor;

import ru.bsd.Configurator.AppConfigurator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContentRedactor {

    public void updateContent(AppConfigurator config, List<String> allLinesFromFiles) {
        if (config.isAppendToFile()) {
            System.out.println("Введите данные через запятую и нажмите 'enter':");
            Scanner scanner = new Scanner(System.in);
            String in = scanner.nextLine();
            if (in.length() == 0) {
                System.out.println("Вы ничего не ввели. \n");
                return;
            } else {
                String[] words = in.split(",");
                allLinesFromFiles.addAll(Arrays.asList(words));
            }
        } else {
            return;
        }
    }
}
