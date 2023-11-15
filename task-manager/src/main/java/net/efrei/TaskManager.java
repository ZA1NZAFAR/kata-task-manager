package net.efrei;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Pair<Integer, String>> stack;
    private int currentId;

    public TaskManager() {
        this.stack = new ArrayList<>();
        currentId = 1;
    }

    public Pair<Character, String> parse(String input) {
        if (input.length() == 1)
            return new Pair<>(input.charAt(0), "");
        else
            return new Pair<>(input.charAt(0), input.substring(2));
    }

    public void add(String description) {
        stack.add(new Pair<>(currentId, description));
        currentId++;
    }

    public List<Pair<Integer, String>> getStack() {
        return stack;
    }
}