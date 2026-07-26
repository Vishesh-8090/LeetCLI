package com.vishesh.leetcli.service;

import com.vishesh.leetcli.model.Problem;
import com.vishesh.leetcli.util.NameFormatter;
import java.io.IOException;
import java.nio.file.*;

/**
 * Service responsible for creating directories
 * and writing LeetCode solution files.
 */
public class FileService {

    private final ConfigService configService;
    private final ReadmeGenerator readmeGenerator;

    public FileService(ConfigService configService, ReadmeGenerator readmeGenerator){
        this.configService = configService;
        this.readmeGenerator = readmeGenerator;
    }

    /**
     * Creates the Java solution file for the given problem.
     *
     * @param problem the problem to persist
     */
    public void createSolutionFile(Problem problem) {
        String folderName =
                problem.getNumber() + "_" + NameFormatter.toClassName(problem.getName());

        String repoPath = configService.getRepositoryPath();

        Path filePath = Paths.get(repoPath, problem.getTopic().name(), folderName, "Solution.java");
        Path directory = filePath.getParent();
        try {
            Files.createDirectories(directory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.writeString(filePath, problem.getSolution());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Path readmePath = directory.resolve("README.md");
        String markdown = readmeGenerator.generate(problem);
        try {
            Files.writeString(readmePath, markdown);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}