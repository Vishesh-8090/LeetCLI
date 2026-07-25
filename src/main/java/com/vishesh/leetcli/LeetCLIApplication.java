package com.vishesh.leetcli;

import com.vishesh.leetcli.model.Problem;
import com.vishesh.leetcli.service.FileService;

import java.io.IOException;

public class LeetCLIApplication {
    public static void main(String[] args) throws IOException {

        Problem problem = new Problem(
                198,
                "House Robber",
                "Dynamic_Programming",
                """
                public class Solution {
            
                }
                """
        );

        FileService fileService = new FileService();
        fileService.createSolutionFile(problem);
    }
}
