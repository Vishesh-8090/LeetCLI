package com.vishesh.leetcli.ui;

import com.vishesh.leetcli.model.Problem;
import com.vishesh.leetcli.model.Topic;
import com.vishesh.leetcli.service.FileService;
import java.io.IOException;
import java.util.*;

/**
 * Handles all console interactions with the user.
 */
public class ConsoleUI {
    private final Scanner sc = new Scanner(System.in);
    private final FileService fileService;

    public ConsoleUI(FileService fileService){
        this.fileService = fileService;
    }

    public void start() throws IOException {

        while (true) {
            showMainMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    addSolution();
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private String readSolution() {
        StringBuilder str = new StringBuilder();
        while (true){
            String line = sc.nextLine();
            if(line.equals("END")) break;
            str.append(line).append("\n");
        }
        return str.toString();
    }

    private Topic readTopic() {
        Topic[] topics = Topic.values();
        int choice;

        while (true){
            for(int i=0; i< topics.length; i++){
                System.out.println(i+1 +". " +topics[i].name());
            }

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice < 1 || choice > topics.length){
                System.out.println("Invalid choice. Try again.");
            }
            else break;
        }
        return topics[choice-1];
    }

    private void showMainMenu(){
        System.out.println("========================");
        System.out.println("        LeetCLI         ");
        System.out.println("========================");

        System.out.println("1. Add Solution");
        System.out.println("2. Exit");
        System.out.print("Choice: ");
    }

    private int readMenuChoice(){
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private void addSolution() throws IOException {
        System.out.print("Enter problem number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter problem name: ");
        String name = sc.nextLine();

        System.out.println("========================");
        System.out.println("      Select Topic      ");
        System.out.println("========================");

        System.out.println("Enter problem topic: ");
        Topic topic = readTopic();

        System.out.println("Enter problem Solution: ");
        System.out.println("Paste your solution below.");
        System.out.println("Type END on a new line when finished.");
        String sol = readSolution();

        Problem problem = new Problem(number, name, topic, sol);

        fileService.createSolutionFile(problem);
    }
}