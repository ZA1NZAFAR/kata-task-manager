package net.efrei;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Pair<Integer, String>> stack;

    public TaskManager() {
        this.stack = new ArrayList<>();
    }

    public Pair<Character, String> parse(String input) {
        if (input.length() == 1)
            return new Pair<>(input.charAt(0), "");
        else
            return new Pair<>(input.charAt(0), input.substring(2));
    }

    public List<Pair<Integer, String>> getStack() {
        return stack;
    }
}