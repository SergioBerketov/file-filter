package ru.bsd.Service.Statistics.DataCollector;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FloatStatistics implements StatisticsData{

    private static final FloatStatistics INSTANCE = new FloatStatistics();

    private FloatStatistics() {
    }

    private List<Double> dataFromFilter = new ArrayList<>();
    private String fileName = "floats.txt";
    private String path = "floats.txt";
    private int floatCounter;
    private double min;
    private double max;
    private double sum;
    private double average;

    public void setDigit(double d) {
        dataFromFilter.add(d);
        this.floatCounter++;
    }

    public String getName() {
        return this.fileName;
    }

    public String getPath() {return path;}

    public int getFloatCounter() {
        return floatCounter;
    }

    public double getMin() {
        return min = Collections.min(dataFromFilter);
    }

    public double getMax() {
        return max = Collections.max(dataFromFilter);
    }

    public double getSum() {
        return this.sum = dataFromFilter.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public double getAverage () {
        return average = this.sum / floatCounter;
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
                ", всего элементов = " + floatCounter +
                ", min = " + getMin() +
                ", max = " + getMax() +
                ", sum = " + getSum() +
                ", average = " + getAverage() +
                '}');
    }

    public static FloatStatistics getInstance() {
        return INSTANCE;
    }
}
