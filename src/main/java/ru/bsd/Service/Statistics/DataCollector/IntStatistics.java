package ru.bsd.Service.Statistics.DataCollector;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IntStatistics implements StatisticsData{

    private static final IntStatistics INSTANCE = new IntStatistics();

    private IntStatistics() {
    }

    private List<Long> dataFromFilter = new ArrayList<>();
    private String fileName = "integers.txt";
    private String path = "integers.txt";
    private long intCounter;
    private long min;
    private long max;
    private long sum;
    private long average;

    public void setDigit(long d) {
        dataFromFilter.add(d);
        this.intCounter++;
    }

    public String getName() {
        return this.fileName;
    }

    public String getPath() {return path;}

    public long getIntCounter() {
        return intCounter;
    }

    public long getMin() {
        return min = Collections.min(dataFromFilter);
    }

    public long getMax() {
        return max = Collections.max(dataFromFilter);
    }

    public long getSum() {
        return this.sum = dataFromFilter.stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    public long getAverage () {
        return average = this.sum / intCounter;
    }

    public List<String> getStringDataForWrite() {
        List<String> strList;
        strList = dataFromFilter.stream().map(Object::toString)
                .collect(Collectors.toList());
        return strList;
    }

    public void setName(String name) {
        this.fileName = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void printFullStat() {
        System.out.println( "Полная статистика{" +
                "Имя файла = '" + fileName + '\'' +
                ", всего элементов = " + intCounter +
                ", min = " + getMin() +
                ", max = " + getMax() +
                ", sum = " + getSum() +
                ", average = " + getAverage() +
                '}');
    }

    public static IntStatistics getInstance() {
        return INSTANCE;
    }
}
