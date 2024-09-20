package ru.bsd.Service.Writer;

import ru.bsd.Configurator.AppConfigurator;
import ru.bsd.Service.FileRedacor.NameRedactor;
import ru.bsd.Service.FileRedacor.PathRedactor;
import ru.bsd.Service.Reader.FileReader;
import ru.bsd.Service.Reader.Reader;
import ru.bsd.Service.Statistics.DataCollector.FloatStatistics;
import ru.bsd.Service.Statistics.DataCollector.IntStatistics;
import ru.bsd.Service.Statistics.DataCollector.StatisticsData;
import ru.bsd.Service.Statistics.DataCollector.StringStatistics;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileWriter implements Writer {

    private IntStatistics intStat = IntStatistics.getInstance();
    private FloatStatistics floatStat = FloatStatistics.getInstance();
    private StringStatistics stringStat = StringStatistics.getInstance();
    private Reader reader = FileReader.getInstance();

    private PathRedactor pathRedactor = new PathRedactor();
    private NameRedactor nameRedactor = new NameRedactor();
    private List<StatisticsData> allElementsForWrite = new ArrayList<>();

    public void writeWithConfig(AppConfigurator config) {
        if (reader.isHasContent()) {
            fillElementsListForWrite();
            nameRedactor.checkPrefixChange(config, allElementsForWrite);
            pathRedactor.checkPathChange(config, allElementsForWrite);

            for (StatisticsData data : allElementsForWrite) {
                List<String> lines = data.getStringDataForWrite();
                if (lines.isEmpty()) {
                    continue;
                } else {
                    try (BufferedWriter writer = new BufferedWriter(
                                                    new java.io.FileWriter(data.getPath(), StandardCharsets.UTF_8))) {
                        for (String line : lines) {
                            writer.write(line);
                            writer.newLine();
                            writer.flush();
                        }
                    } catch (IOException e) {
                        System.out.println("Не удалось найти указанный путь.");
                        break;
                    }
                }
            }
        } else {
            return;
        }
    }

    private void fillElementsListForWrite() {
        allElementsForWrite.add(intStat);
        allElementsForWrite.add(floatStat);
        allElementsForWrite.add(stringStat);
    }
}

