package ru.bsd.Service.FileRedacor;

import ru.bsd.Configurator.AppConfigurator;
import ru.bsd.Service.Statistics.DataCollector.StatisticsData;

import java.util.List;

public class PathRedactor {

    public void checkPathChange(AppConfigurator config, List<StatisticsData> data) {
        if (config.isNewPathForFile()) {
            String newPath;
            String in = config.getNewPathForFile();
            if (!in.contains("\\") & !in.contains("/")) {
                System.out.println("Для изменения стандартного пути сохранения файлов," +
                        "необходимо после параметра '-o' ввести новый корректный путь.");
                return;
            } else {
                for (StatisticsData element : data) {
                    newPath = in + "/" + element.getName();
                    element.setPath(newPath);
                }
            }
        } else {
            return;
        }
    }
}
