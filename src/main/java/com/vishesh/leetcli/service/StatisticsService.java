package com.vishesh.leetcli.service;

import com.vishesh.leetcli.model.Statistics;
import com.vishesh.leetcli.model.Topic;
import java.io.IOException;
import java.nio.file.*;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Service responsible for analysing the repository
 * and generating statistics.
 */
public class StatisticsService {

    private final ConfigService configService;

    public StatisticsService(ConfigService configService){
        this.configService = configService;
    }

    public Statistics getStatistics(){
        String repoPath = configService.getRepositoryPath();

        Path root = Paths.get(repoPath);
        int totalProblems = 0;

        Map<Topic, Integer> topicStatistics = new EnumMap<>(Topic.class);

        try (Stream<Path> paths = Files.walk(root)){

            List<Path> problemDirectories = paths
                    .filter(Files::isDirectory)
                    .filter(path -> root.relativize(path).getNameCount() == 2)
                    .toList();

            for (Path path : problemDirectories) {
                totalProblems++;

                String folderName = path.getParent().getFileName().toString().toUpperCase();

                Topic topic = Topic.valueOf(folderName);

                topicStatistics.merge(topic, 1, Integer::sum);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Statistics(
                totalProblems,
                topicStatistics
        );
    }
}
