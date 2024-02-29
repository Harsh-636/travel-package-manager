package model.passenger.impl;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import model.Activity;

public class PremiumPassengerTest {
    private Activity activity;

    private PremiumPassenger premiumPassenger;

    @Before
    public void setUp() {
        premiumPassenger = new PremiumPassenger("Harsh", 123456);
    }

    @Test
    public void testRegisterForActivity_Success() {

        activity = new Activity("Slides", "Description", 500.0, 5);

        // Registering for activity
        premiumPassenger.registerForActivity(activity);

        // Assert that the activity is registered for the passenger
        assertEquals(1, premiumPassenger.getRegisteredActivities().size());
    }

    @Test
    public void testRegisterForActivity_InsufficientBalance() {
        // Mocking activity details
        activity = new Activity("Roller Coaster", "Description", 5000.0, 5);

        // Registering for activity for premium passenger
        premiumPassenger.registerForActivity(activity);

        // Assert that the activity is not registered
        assertEquals(1, premiumPassenger.getRegisteredActivities().size());
    }

    @Test
    public void testRegisterForActivity_NoCapacity() {

        activity = new Activity("Laser Tag", "Description", 30.0, 0);

        // Registering for activity with no capacity
        premiumPassenger.registerForActivity(activity);

        // Assert that the activity is not registered for the passenger
        assertEquals(0, premiumPassenger.getRegisteredActivities().size());
    }
}
