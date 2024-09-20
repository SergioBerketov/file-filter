package ru.bsd.Service.Statistics;

import ru.bsd.Service.Statistics.DataCollector.FloatStatistics;
import ru.bsd.Service.Statistics.DataCollector.IntStatistics;
import ru.bsd.Service.Statistics.DataCollector.StringStatistics;

public class FullStatStrategy implements Statistics{

    private IntStatistics intStatData = IntStatistics.getInstance();
    private FloatStatistics floatStatData = FloatStatistics.getInstance();
    private StringStatistics strStatData = StringStatistics.getInstance();

    @Override
    public void printStat() {
        intStatData.printFullStat();
        floatStatData.printFullStat();
        strStatData.printFullStat();
    }
}
