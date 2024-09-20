package ru.bsd.Service.Statistics;

import ru.bsd.Service.Statistics.DataCollector.FloatStatistics;
import ru.bsd.Service.Statistics.DataCollector.IntStatistics;
import ru.bsd.Service.Statistics.DataCollector.StringStatistics;

public class ShortStatStrategy implements Statistics {

    private IntStatistics intStatData = IntStatistics.getInstance();
    private FloatStatistics floatStatData = FloatStatistics.getInstance();
    private StringStatistics strStatData = StringStatistics.getInstance();

    @Override
    public void printStat() {
        System.out.println("Короткая статистика {" +
                "Количество элементов в файле " + intStatData.getName() + " = " + intStatData.getIntCounter() + ", " +
                "Количество элементов в файле " + floatStatData.getName() + " = " + floatStatData.getFloatCounter() + ", " +
                "Количество элементов в файле " + strStatData.getName() + " = " + strStatData.getStrCounter() +
                '}');
    }
}
