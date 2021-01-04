package agh.cs.project.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreaTest {

    @Test
    void contains() {
        Area area = new Area(new Vector2(0, 0), new Vector2(5, 5));
        assertTrue(area.contains(new Vector2(0, 0)));
        assertTrue(area.contains(new Vector2(1, 3)));
        assertTrue(area.contains(new Vector2(4, 2)));
        assertTrue(area.contains(new Vector2(4, 3)));
        assertTrue(area.contains(new Vector2(3, 4)));
        assertTrue(area.contains(new Vector2(4, 4)));
        assertFalse(area.contains(new Vector2(6, 5)));
        assertFalse(area.contains(new Vector2(5, 6)));
        assertFalse(area.contains(new Vector2(3, 6)));
        assertFalse(area.contains(new Vector2(-1, 5)));
    }
}