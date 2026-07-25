package com.vishesh.leetcli.util;

/**
 * Utility class for formatting LeetCode problem names
 * into valid Java file names.
 *
 * Example:
 * House Robber -> HouseRobber
 */
public final class NameFormatter {

    private NameFormatter(){}

    /**
     * Converts a LeetCode problem name into a valid Java file name.
     *
     * @param problemName the original LeetCode problem name
     * @return the formatted Java file name
     */
    public static String toClassName(String problemName){
        String[] s = problemName.trim().split("\\s+");

        StringBuilder fileName = new StringBuilder();

        for (String str : s) {
            fileName.append(Character.toUpperCase(str.charAt(0)))
                    .append(str.substring(1));
        }

        return fileName.toString();
    }
}
