package com.vishesh.leetcli;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.vishesh.leetcli.model.Problem;
import com.vishesh.leetcli.service.ConfigService;
import com.vishesh.leetcli.service.FileService;
import com.vishesh.leetcli.ui.ConsoleUI;

import java.io.IOException;
import java.util.Properties;

public class LeetCLIApplication {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        ConfigService configService = new ConfigService(properties);

        FileService fileService = new FileService(configService);

        ConsoleUI consoleUI = new ConsoleUI(fileService);
        consoleUI.start();
    }
}
