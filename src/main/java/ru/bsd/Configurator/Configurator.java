package ru.bsd.Configurator;

import com.beust.jcommander.JCommander;

public class Configurator {

    public AppConfigurator configure(String[] args) {
        AppConfigurator configurator = new AppConfigurator();
        JCommander.newBuilder()
                .addObject(configurator)
                .build()
                .parse(args);
        return configurator;
    }
}
