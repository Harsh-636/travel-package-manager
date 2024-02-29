package model.passenger.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import model.Activity;

public class GoldPassengerTest {
    
    private Activity activity;

    private GoldPassenger goldPassenger;

    @Before
    public void setUp() {
        goldPassenger = new GoldPassenger("Harsh", 123456, 1000.0);
    }

    @Test
    public void testRegisterForActivity_Success() {

        activity = new Activity("test activity", "Description", 500.0, 5);

        // Registering for activity
        goldPassenger.registerForActivity(activity);

        // Assert that the activity is registered for the passenger
        assertTrue(goldPassenger.getRegisteredActivities().containsKey(activity));
        assertEquals(1, goldPassenger.getRegisteredActivities().size());

        // Assert that the balance is updated correctly
        assertEquals(550.0, goldPassenger.getBalance(), 0.01);
    }

    @Test
    public void testRegisterForActivity_InsufficientBalance() {
        // Mocking activity details
        activity = new Activity("Roller Coaster", "Description", 5000.0, 5);

        // Registering for activity with insufficient balance
        goldPassenger.registerForActivity(activity);

        // Assert that the activity is not registered
        assertFalse(goldPassenger.getRegisteredActivities().containsKey(activity));
        assertEquals(0, goldPassenger.getRegisteredActivities().size());

        // Assert that the balance remains unchanged
        assertEquals(1000.0, goldPassenger.getBalance(), 0.01);
    }

    @Test
    public void testRegisterForActivity_NoCapacity() {

        activity = new Activity("Laser Tag", "Description", 30.0, 0);

        // Registering for activity with no capacity
        goldPassenger.registerForActivity(activity);

        // Assert that the activity is not registered for the passenger
        assertFalse(goldPassenger.getRegisteredActivities().containsKey(activity));
        assertEquals(0, goldPassenger.getRegisteredActivities().size());

        // Assert that the balance remains unchanged
        assertEquals(1000.0, goldPassenger.getBalance(), 0.01);
    }

}
