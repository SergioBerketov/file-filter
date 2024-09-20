package ru.bsd.Service.Statistics;

public class FullStatistics extends StatisticsFactory{
    @Override
    public Statistics chooseStatistics() {
        return new FullStatStrategy();
    }

}
