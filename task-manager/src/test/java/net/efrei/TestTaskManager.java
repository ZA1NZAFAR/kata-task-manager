package net.efrei;

import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
