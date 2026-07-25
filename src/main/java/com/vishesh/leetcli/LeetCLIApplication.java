package com.vishesh.leetcli;

import com.vishesh.leetcli.model.Problem;
import com.vishesh.leetcli.service.FileService;
import com.vishesh.leetcli.ui.ConsoleUI;

import java.io.IOException;

public class LeetCLIApplication {
    public static void main(String[] args) throws IOException {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
}
