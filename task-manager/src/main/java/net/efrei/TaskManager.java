package net.efrei;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Triplet<Integer, Boolean, String>> stack;
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
        stack.add(new Triplet<>(currentId, false, description));
        currentId++;
    }

    public int find(int id) throws Exception {
        for (int i = 0; i < stack.size(); i++) {
            if (id == stack.get(i).getValue0()) return i;
        }
        throw new Exception("Element not found");
    }

    public List<Triplet<Integer, Boolean, String>> getStack() {
        return stack;
    }

    public void delete(int id) throws Exception {
        stack.remove(this.find(id));
    }

    public void setStatusDone(int id) throws Exception {
        stack.set(this.find(id), stack.get(this.find(id)).setAt1(true));
    }

    public void setStatusToDo(int id) throws Exception {
        stack.set(this.find(id), stack.get(this.find(id)).setAt1(false));
    }

    public void printStack() {
        if (stack.isEmpty()) {
            System.out.println("No task yet");
            return;
        }
        for (Triplet<Integer, Boolean, String> task : stack) {
            System.out.println(task.getValue0() + " - " + (task.getValue1() ? "[X]" : "[ ]") + " - " + task.getValue2());
        }
    }
}