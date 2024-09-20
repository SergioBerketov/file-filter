package ru.bsd.Service.Statistics;

public class ShortStatistics extends StatisticsFactory {
    @Override
    public Statistics chooseStatistics() {
        return new ShortStatStrategy();
    }
}
