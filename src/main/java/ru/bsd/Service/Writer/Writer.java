package ru.bsd.Service.Writer;

import ru.bsd.Configurator.AppConfigurator;
import ru.bsd.Service.Reader.Reader;

public interface Writer {
    void writeWithConfig(AppConfigurator config);
}
