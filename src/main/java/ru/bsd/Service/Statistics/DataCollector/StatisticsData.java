package ru.bsd.Service.Statistics.DataCollector;

import java.util.List;

public interface StatisticsData {
    String getName();
    String getPath();
    List<String> getStringDataForWrite();
    void setName(String fileName);
    void setPath(String newPath);
}
