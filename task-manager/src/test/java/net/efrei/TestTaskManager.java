package net.efrei;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTaskManager {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testParsePlus() {
        Pair<Character, String> result = taskManager.parse("+ Learn JAVA");
        Pair<Character, String> expected = new Pair<>('+', "Learn JAVA");

        assertEquals(expected, result);
    }

    @Test
    public void testParseQ() {
        Pair<Character, String> result = taskManager.parse("q");
        Pair<Character, String> expected = new Pair<>('q', "");

        assertEquals(expected, result);
    }


    @Test
    public void testInitStack() {
        List<Triplet<Integer, Boolean, String>> result = taskManager.getStack();
        List<Triplet<Integer, Boolean, String>> expected = List.of();

        assertEquals(expected, result);
    }

    @Test
    public void testAddTask() {
        taskManager.add("Learn JAVA");
        List<Triplet<Integer, Boolean, String>> result = taskManager.getStack();
        List<Triplet<Integer, Boolean, String>> expected = List.of(new Triplet<>(1, false, "Learn JAVA"));

        assertEquals(expected, result);
    }

    @Test
    public void testFindIndexTask() throws Exception {
        taskManager.add("Learn JAVA");
        taskManager.add("Learn PYTHON");

        int resultIndex = taskManager.find(2);

        assertEquals(1, resultIndex);
    }

    @Test
    public void testFindInvalidIndexTask() {
        taskManager.add("Learn JAVA");
        taskManager.add("Learn PYTHON");

        assertThrows(Exception.class, () -> taskManager.find(3));
    }

    @Test
    public void testDeleteTask() throws Exception {
        taskManager.add("Learn JAVA");
        taskManager.add("Learn PYTHON");

        taskManager.delete(1);
        List<Triplet<Integer, Boolean, String>> result = taskManager.getStack();
        List<Triplet<Integer, Boolean, String>> expected = List.of(new Triplet<>(2, false, "Learn PYTHON"));

        assertEquals(expected, result);
    }

}
