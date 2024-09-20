package ru.bsd.Controller;

import ru.bsd.Configurator.AppConfigurator;
import ru.bsd.Configurator.Configurator;

import ru.bsd.Service.Reader.FileReader;
import ru.bsd.Service.Reader.Reader;
import ru.bsd.Service.Statistics.StatisticsSelector;
import ru.bsd.Service.Writer.FileWriter;
import ru.bsd.Service.Writer.Writer;

public class AppController implements Controller {

    private Configurator configurator = new Configurator();
    private Reader reader = FileReader.getInstance();
    private Writer writer = new FileWriter();
    private StatisticsSelector statistics = new StatisticsSelector();

    public void run(String[] args) {
        AppConfigurator appConfig = configurator.configure(args);
        reader.readWithConfig(appConfig);
        writer.writeWithConfig(appConfig);
        statistics.provideGeneratedStat(appConfig);
    }
}
