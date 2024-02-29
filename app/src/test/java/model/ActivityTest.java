package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest {

    @Test
    public void testConstructorAndGetters() {
        Activity activity = new Activity("Slides", "Slides for children", 50.0, 10);

        // Test constructor and getters
        assertEquals("Slides", activity.getName());
        assertEquals("Slides for children", activity.getDescription());
        assertEquals(50.0, activity.getCost(), 0.01);
        assertEquals(10, activity.getCapacity().intValue());
    }

    @Test
    public void testEqualsAndHashCode() {
        Activity activity1 = new Activity("Slides", "Slides for children", 50.0, 10);
        Activity activity2 = new Activity("Slides", "Slides for children", 50.0, 10);

        assertTrue(activity1.equals(activity2));
        assertTrue(activity2.equals(activity1));

        assertEquals(activity1.hashCode(), activity2.hashCode());
    }

    @Test
    public void testToString() {

        Activity activity = new Activity("Slides", "Slides for children", 50.0, 10);

        String expectedToString = "Activity(name=Slides, description=Slides for children, cost=50.0, capacity=10)";
        assertEquals(expectedToString, activity.toString());
    }
}