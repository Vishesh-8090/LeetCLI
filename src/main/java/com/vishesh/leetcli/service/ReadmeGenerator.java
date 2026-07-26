package com.vishesh.leetcli.service;

import com.vishesh.leetcli.model.Problem;

public class ReadmeGenerator {

    public String generate(Problem problem){
        StringBuilder markdown = new StringBuilder();

        markdown.append("# ");
        markdown.append(problem.getNumber());
        markdown.append(". ");
        markdown.append(problem.getName());
        markdown.append("\n\n");
        markdown.append("## Topic\n\n");
        markdown.append(problem.getTopic().getDisplayName());
        markdown.append("\n\n");
        markdown.append("## Solution Language\n\n");
        markdown.append("Java\n\n");
        markdown.append("## Notes\n\n");
        markdown.append("_Add your notes here._\n");

        return markdown.toString();
    }
}
