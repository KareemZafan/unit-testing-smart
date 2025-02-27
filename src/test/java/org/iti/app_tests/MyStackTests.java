package org.iti.app_tests;

import org.iti.app.MyStack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTests {

    private MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();
    }

    @Test
    void testPushToStack() {
        assertNotNull(myStack);
        assertTrue(myStack.isEmpty());

        myStack.push(List.of(1, 2, 3, 1000));

        assertEquals(4, myStack.getSize());
        assertEquals(1000, myStack.getPeek());
        assertEquals(List.of(1, 2, 3, 1000), myStack.getCurrentStack());
    }

    @Test
    void testPopItemsFromStack() {

        assertNotNull(myStack);
        assertTrue(myStack.isEmpty());

        var ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.pop());
        assertEquals("Stack is Empty!", ex.getMessage());

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(1000);
        myStack.push(2000);
        myStack.push(3000);

        assertEquals(3000, myStack.getPeek());
        assertEquals(3000, myStack.pop());
        assertEquals(5, myStack.getSize());
        assertEquals(2000, myStack.getPeek());
        assertEquals(List.of(1, 2, 3, 1000, 2000), myStack.getCurrentStack());
    }
}
