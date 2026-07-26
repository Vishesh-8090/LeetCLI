package com.vishesh.leetcli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {

    private int totalProblems;
    private Map<Topic, Integer> topicStatistics;
}
