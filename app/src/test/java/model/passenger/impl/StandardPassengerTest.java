package model.passenger.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import model.Activity;

public class StandardPassengerTest {
    
    private Activity activity;

    private StandardPassenger standardPassenger;

    @Before
    public void setUp() {
        standardPassenger = new StandardPassenger("Harsh", 123456, 1000.0);
    }

    @Test
    public void testRegisterForActivity_Success() {

        activity = new Activity("Slides", "Description", 500.0, 5);

        // Registering for activity
        standardPassenger.registerForActivity(activity);

        // Assert that the activity is registered for the passenger
        assertEquals(1, standardPassenger.getRegisteredActivities().size());

        // Assert that the balance is updated correctly
        assertEquals(500.0, standardPassenger.getBalance(), 0.01);
    }

    @Test
    public void testRegisterForActivity_InsufficientBalance() {
        // Mocking activity details
        activity = new Activity("Roller Coaster", "Description", 5000.0, 5);

        // Registering for activity with insufficient balance
        standardPassenger.registerForActivity(activity);

        // Assert that the activity is not registered
        assertFalse(standardPassenger.getRegisteredActivities().containsKey(activity));
        assertEquals(0, standardPassenger.getRegisteredActivities().size());

        // Assert that the balance remains unchanged
        assertEquals(1000.0, standardPassenger.getBalance(), 0.01);
    }

    @Test
    public void testRegisterForActivity_NoCapacity() {

        activity = new Activity("Laser Tag", "Description", 30.0, 0);

        // Registering for activity with no capacity
        standardPassenger.registerForActivity(activity);

        // Assert that the activity is not registered for the passenger
        assertFalse(standardPassenger.getRegisteredActivities().containsKey(activity));
        assertEquals(0, standardPassenger.getRegisteredActivities().size());

        // Assert that the balance remains unchanged
        assertEquals(1000.0, standardPassenger.getBalance(), 0.01);
    }

}
