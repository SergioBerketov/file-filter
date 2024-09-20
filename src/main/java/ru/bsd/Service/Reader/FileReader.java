package ru.bsd.Service.Reader;

import ru.bsd.Configurator.AppConfigurator;
import ru.bsd.Service.DataFilter.DataFilter;
import ru.bsd.Service.FileRedacor.ContentRedactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Reader {

    private static final FileReader INSTANCE = new FileReader();

    private FileReader() {
    }

    private ContentRedactor redactor = new ContentRedactor();
    private DataFilter filter = new DataFilter();
    private static List<String> fileNames = new ArrayList<>();
    private static List<String> allLinesFromFiles = new ArrayList<>();

    public void readWithConfig(AppConfigurator config) {
        checkPath(config);

        for (String currentPath : fileNames) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(currentPath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    allLinesFromFiles.add(line);
                }
            } catch (IOException e) {
                System.out.println("Указанные в параметрах файлы не найдены.\n" +
                                    "Убедитесь что они находятся в одной директории с программой.");
                return;
            }
        }
        redactor.updateContent(config, allLinesFromFiles);

        if (isHasContent()) {
            filter.filtration(allLinesFromFiles);
        } else {
            System.out.println("В файлах нет данных для фильтрации.");
           return;
        }
    }

    private static void checkPath(AppConfigurator config) {
        if (config.isFirstTxtFlag()) {
            fileNames.add("in1.txt");
        }
        if (config.isSecondTxtFlag()) {
            fileNames.add("in2.txt");
        }
        if (fileNames.isEmpty()) {
            System.out.println("Укажите в параметрах имя файлов для фильтрации.");
        }
    }

    public boolean isHasContent() {
        List<String> content = allLinesFromFiles;
        return content != null && !content.isEmpty();
    }

    public static FileReader getInstance() {
        return INSTANCE;
    }
}

