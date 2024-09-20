package ru.bsd.Service.Statistics;

public abstract class StatisticsFactory {

    public void print() {
        Statistics statistics = chooseStatistics();
        statistics.printStat();
    }

    public abstract Statistics chooseStatistics();
}
