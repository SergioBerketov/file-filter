package ru.bsd.Service.Reader;

import ru.bsd.Configurator.AppConfigurator;

public interface Reader {
    void readWithConfig(AppConfigurator config);
    boolean isHasContent ();
}
