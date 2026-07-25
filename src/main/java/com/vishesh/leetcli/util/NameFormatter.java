package com.vishesh.leetcli.util;

/**
 * Utility class for formatting LeetCode problem names
 * into valid Java file names.
 *
 * Example:
 * House Robber -> HouseRobber.java
 */
public final class NameFormatter {

    private NameFormatter(){}

    /**
     * Converts a LeetCode problem name into a valid Java file name.
     *
     * @param problemName the original LeetCode problem name
     * @return the formatted Java file name
     */
    public static String toJavaFileName(String problemName){
        String[] s = problemName.trim().split("\\s+");
        StringBuilder fileName = new StringBuilder();

        for (String str : s) {
            char ch = str.charAt(0);
            ch = Character.toUpperCase(ch);
            str = ch + str.substring(1);
            fileName.append(str);
        }
        fileName.append(".java");

        return fileName.toString();
    }
}
