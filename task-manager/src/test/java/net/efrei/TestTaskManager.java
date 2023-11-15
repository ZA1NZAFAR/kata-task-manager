package net.efrei;

import org.javatuples.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaskManager {

    private static TaskManager taskManager;

    @BeforeAll
    public static void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testParsePlus() {
        Pair<Character, String> result =  taskManager.parse("+ Learn JAVA");
        Pair<Character, String> expected = new Pair<>('+', "Learn JAVA");

        assertEquals(expected, result);
    }

}
