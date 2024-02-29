package model.travelpackage;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import model.Activity;
import model.Destination;
import model.passenger.impl.GoldPassenger;
import model.passenger.impl.Passenger;
import model.passenger.impl.StandardPassenger;
import model.travelpackage.impl.TravelPackage;

public class TravelPackageTest {

    private TravelPackage travelPackage;

    @Before
    public void setUp() {

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Slides", "SLides for children", 50.0, 10));
        activities.add(new Activity("Rollercoaster", "Thrilling joyride", 30.0, 15));

        Destination destination = Destination.builder()
                                    .name("Imagica")
                                    .activities(activities)
                                    .build();

        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new StandardPassenger("Harsh", 123456, 500.0));
        passengers.add(new GoldPassenger("Aarti", 654321, 1000.0));

        travelPackage = TravelPackage.builder()
                            .name("Pune Tour")
                            .passengerCapacity(50)
                            .itinerary(itinerary)
                            .passengers(passengers)
                            .build();
    }

    @Test
    public void testAddDestination() {
        // Create a new destination
        Destination newDestination = Destination.builder()
                                            .name("Mountain")
                                            .build();

        travelPackage.addDestination(newDestination);
        assertTrue(travelPackage.getItinerary().contains(newDestination));
    }

    @Test
    public void testAddPassenger() {

        Passenger newPassenger = new StandardPassenger("Shubhangi", 987654, 800.0);
        travelPackage.addPassenger(newPassenger);

        assertTrue(travelPackage.getPassengers().contains(newPassenger));
    }
}