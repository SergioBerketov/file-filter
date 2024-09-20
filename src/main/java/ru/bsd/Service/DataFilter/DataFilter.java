package ru.bsd.Service.DataFilter;

import ru.bsd.Service.Statistics.DataCollector.FloatStatistics;
import ru.bsd.Service.Statistics.DataCollector.IntStatistics;
import ru.bsd.Service.Statistics.DataCollector.StringStatistics;
import java.util.List;

public class DataFilter {

    private IntStatistics intStat = IntStatistics.getInstance();
    private FloatStatistics floatStat = FloatStatistics.getInstance();
    private StringStatistics stringStat = StringStatistics.getInstance();

    public void filtration(List<String> linesForParse) {
        for (String s : linesForParse) {
            if (isInteger(s)) {
                intStat.setDigit(Long.parseLong(s));
            } else if (isFloat(s)) {
                floatStat.setDigit(Double.parseDouble(s));
            } else {
                stringStat.setLine(s);
            }
        }
    }

    private static boolean isInteger(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

