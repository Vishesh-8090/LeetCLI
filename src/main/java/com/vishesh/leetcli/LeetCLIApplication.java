package com.vishesh.leetcli;

import com.vishesh.leetcli.service.ConfigService;
import com.vishesh.leetcli.service.FileService;
import com.vishesh.leetcli.service.ReadmeGenerator;
import com.vishesh.leetcli.service.StatisticsService;
import com.vishesh.leetcli.ui.ConsoleUI;

import java.io.IOException;
import java.util.Properties;

public class LeetCLIApplication {
    public static void main(String[] args) {

        Properties properties = new Properties();

        ConfigService configService = new ConfigService(properties);

        ReadmeGenerator readmeGenerator = new ReadmeGenerator();

        FileService fileService = new FileService(configService, readmeGenerator);

        StatisticsService statisticsService = new StatisticsService(configService);

        ConsoleUI consoleUI = new ConsoleUI(fileService, statisticsService);
        consoleUI.start();
    }
}
