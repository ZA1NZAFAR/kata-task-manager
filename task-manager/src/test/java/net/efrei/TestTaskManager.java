package net.efrei;

import jdk.internal.util.xml.impl.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaskManager {

    private TaskManager taskManager;

    @BeforeAll
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testParsePlus() {
        Pair result =  taskManager.parse("+ Learn JAVA");
        Pair expected = new Pair();
        expected.name = "+";
        expected.value = "Learn JAVA";

        assertEquals(expected, result);
    }

}
