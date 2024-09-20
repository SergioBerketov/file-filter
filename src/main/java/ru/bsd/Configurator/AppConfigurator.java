package ru.bsd.Configurator;

import com.beust.jcommander.Parameter;

public class AppConfigurator {

    @Parameter(names = {"in1.txt"})
    private boolean isFirstTxtFlag;

    @Parameter(names = {"in2.txt"})
    private boolean isSecondTxtFlag;

    @Parameter(names = {"-o"})
    private String newPathForFile;

    @Parameter(names = {"-p"})
    private String userPrefixArg;

    @Parameter(names = {"-a"})
    private boolean appendToFile;

    @Parameter(names = {"-s"})
    private boolean shortStatistics;

    @Parameter(names = {"-f"})
    private boolean fullStatistics;

    public boolean isFirstTxtFlag() {
        return isFirstTxtFlag;
    }

    public boolean isSecondTxtFlag() {
        return isSecondTxtFlag;
    }

    public boolean isNewPathForFile() {
        return newPathForFile != null;
    }

    public boolean isNamePrefix() {return userPrefixArg != null;}

    public boolean isAppendToFile() {return appendToFile;}

    public boolean isShortStatistics() {return shortStatistics;}

    public boolean isFullStatistics() {return fullStatistics;}

    public String getUserPrefixArg() {return userPrefixArg;}

    public String getNewPathForFile() {return newPathForFile;}
}
