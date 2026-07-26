package com.vishesh.leetcli.model;

public enum Topic {
    ARRAYS("Arrays"),
    STRINGS("Strings"),
    LINKED_LIST("Linked List"),
    STACK("Stack"),
    QUEUE("Queue"),
    TREE("Tree"),
    GRAPH("Graph"),
    DYNAMIC_PROGRAMMING("Dynamic Programming"),
    GREEDY("Greedy"),
    BACKTRACKING("Backtracking"),
    BINARY_SEARCH("Binary Search"),
    HEAP("Heap");

    private final String displayName;

    Topic(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}