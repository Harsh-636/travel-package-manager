package model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class DestinationTest {

    @Test
    public void testConstructorAndGetters() {

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Slides", "SLides for children", 50.0, 10));
        activities.add(new Activity("Rollercoaster", "Thrilling joyride", 30.0, 15));

        Destination destination = Destination.builder()
                                    .name("Imagica")
                                    .activities(activities)
                                    .build();

        assertEquals("Imagica", destination.getName());
        assertEquals(2, destination.getActivities().size());
        assertEquals("Slides", destination.getActivities().get(0).getName());
        assertEquals("Rollercoaster", destination.getActivities().get(1).getName());
    }

    @Test
    public void testBuilder() {
        Destination destination = Destination.builder()
                                    .name("Juhu")
                                    .build();

        assertEquals("Juhu", destination.getName());
        assertNull(destination.getActivities());
    }
}