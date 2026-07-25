package com.vishesh.leetcli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Problem {

    private int number;
    private String name;
    private Topic topic;
    private String solution;
}
