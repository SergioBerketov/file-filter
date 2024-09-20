package ru.bsd.Service.Statistics;

import ru.bsd.Configurator.AppConfigurator;
import ru.bsd.Service.Reader.FileReader;
import ru.bsd.Service.Reader.Reader;

public class StatisticsSelector {

    private static StatisticsFactory factory;
    private Reader reader = FileReader.getInstance();

    public void provideGeneratedStat(AppConfigurator appConfig) {
        if (reader.isHasContent()) {
            String parameter;
            if (appConfig.isShortStatistics()) {
                parameter = "shortStat";
                configure(parameter);
                showStatistics();
            } else if (appConfig.isFullStatistics()) {
                parameter = "fullStat";
                configure(parameter);
                showStatistics();
            }
        } else {
            return;
        }
    }

    public static void configure(String statParameter) {
        if (statParameter.equals("shortStat")) {
            factory = new ShortStatistics();
        } else if (statParameter.equals("fullStat")) {
            factory = new FullStatistics();
        }
    }

    private static void showStatistics() {
        factory.print();
    }
}
