package ru.bsd.Service.FileRedacor;

import ru.bsd.Configurator.AppConfigurator;
import ru.bsd.Service.Statistics.DataCollector.StatisticsData;

import java.util.List;

public class NameRedactor {

    public void checkPrefixChange(AppConfigurator config, List<StatisticsData> data) {
        if (config.isNamePrefix()) {
            String nameWithPrefix;
            String in = config.getUserPrefixArg();
            if (in.contains(".txt")) {
                System.out.println("Для добавления префикса к стандартному имени файлов, " +
                                    "введите его после параметра '-p'.");
                return;
            } else {
                for (StatisticsData element : data) {
                    nameWithPrefix = in + element.getName();
                    element.setName(nameWithPrefix);
                    element.setPath(nameWithPrefix);
                }
            }
        } else{
            return;
        }
    }
}

