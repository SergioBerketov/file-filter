package ru.bsd.Service.Statistics.DataCollector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class StringStatistics implements StatisticsData{

    private static final StringStatistics INSTANCE = new StringStatistics();

    private StringStatistics() {
    }

    private List<String> dataFromFilter = new ArrayList<>();
    private String fileName = "strings.txt";
    private String path = "strings.txt";
    private int strCounter;
    private int shortestString;
    private int longestString;

    public void setLine(String s) {
        dataFromFilter.add(s);
        this.strCounter++;
    }

    public String getName() {
        return this.fileName;
    }

    public String getPath() {return path;}

    public int getStrCounter() {
        return strCounter;
    }

    public int getShortestString() {
        return shortestString = Collections.min(dataFromFilter, comparing(String::length)).length();
    }

    public int getLongestString() {
        return this.longestString = Collections.max(dataFromFilter, comparing(String::length)).length();
    }
    public List<String> getStringDataForWrite() {
        return dataFromFilter;
    }

    public void setName(String name) {
        this.fileName = name;
    }

    public void setPath(String path) {this.path = path;}

    public void printFullStat() {
        System.out.println( "Полная статистика{" +
                "Имя файла = '" + fileName + '\'' +
                ", всего элементов = " + getStrCounter() +
                ", минимальная по размеру строка = " + getShortestString() + " символа" +
                ", максимальная по размеру строка = " + getLongestString() + " символа" +
                '}');
    }

    public static StringStatistics getInstance() {
        return INSTANCE;
    }
}
