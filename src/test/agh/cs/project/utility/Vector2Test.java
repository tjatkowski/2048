package agh.cs.project.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2Test {

    @Test
    void add() {
        assertEquals(new Vector2(0, 0).add(new Vector2(5, -5)), new Vector2(5, -5));
        assertEquals(new Vector2(12, 14).add(new Vector2(-12, -14)), new Vector2(0, 0));
        assertEquals(new Vector2(1, 2).add(new Vector2(0, 0)), new Vector2(1, 2));
        assertEquals(new Vector2(5, 4).add(new Vector2(5, -5)), new Vector2(10, -1));
    }

    @Test
    void testMultiply0() {
        assertEquals(new Vector2(0, 0).multiply(5), new Vector2(0, 0));
        assertEquals(new Vector2(1, 1).multiply(5), new Vector2(5, 5));
        assertEquals(new Vector2(2, 2).multiply(5), new Vector2(10, 10));
    }

    @Test
    void testMultiply1() {
        assertEquals(new Vector2(0, 0).multiply(5.0f), new Vector2(0, 0));
        assertEquals(new Vector2(1, 1).multiply(5.0f), new Vector2(5, 5));
        assertEquals(new Vector2(2, 2).multiply(5.0f), new Vector2(10, 10));
    }

    @Test
    void testMultiply2() {
        assertEquals(new Vector2(0, 0).multiply(new Vector2(0, 0)), new Vector2(0, 0));
        assertEquals(new Vector2(1, 1).multiply(new Vector2(5, 10)), new Vector2(5, 10));
        assertEquals(new Vector2(2, 2).multiply(new Vector2(2, 4)), new Vector2(4, 8));
    }

    @Test
    void smallerThan() {
        assertTrue(new Vector2(0, 0).smallerThan(new Vector2(1, 0)));
        assertTrue(new Vector2(0, 0).smallerThan(new Vector2(0, 1)));
        assertTrue(new Vector2(0, 0).smallerThan(new Vector2(1, 1)));
    }

    @Test
    void biggerThan() {
        assertTrue(new Vector2(0, 0).biggerThan(new Vector2(-1, 0)));
        assertTrue(new Vector2(0, 0).biggerThan(new Vector2(0, -1)));
        assertTrue(new Vector2(0, 0).biggerThan(new Vector2(-1, -1)));
    }

    @Test
    void testToString() {
        assertEquals(new Vector2(5, 3).toString(), "(5, 3)");
    }

    @Test
    void testEquals() {
        assertEquals(new Vector2(5, 2), new Vector2(5, 2));
    }
}