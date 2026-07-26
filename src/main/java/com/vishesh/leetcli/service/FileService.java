package com.vishesh.leetcli.service;

import com.vishesh.leetcli.model.Problem;
import com.vishesh.leetcli.util.NameFormatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.function.Function;

/**
 * Service responsible for creating directories
 * and writing LeetCode solution files.
 */
public class FileService {

    private final ConfigService configService;

    public FileService(ConfigService configService){
        this.configService = configService;
    }

    /**
     * Creates the Java solution file for the given problem.
     *
     * @param problem the problem to persist
     */
    public void createSolutionFile(Problem problem) throws IOException {
        String folderName =
                problem.getNumber() + "_" + NameFormatter.toClassName(problem.getName());

        String repoPath = configService.getRepositoryPath();

        Path filePath = Paths.get(repoPath, problem.getTopic().name(), folderName, "Solution.java");
        Path directory = filePath.getParent();
        Files.createDirectories(directory);

        Files.writeString(filePath, problem.getSolution());

        System.out.println(filePath);
    }
}