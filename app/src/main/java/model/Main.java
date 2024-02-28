package model;

import java.util.Arrays;
import model.passenger.impl.Passenger;
import model.passenger.impl.StandardPassenger;
import model.travelpackage.impl.TravelPackage;

public class Main {

    public static void main(String[] args) {
        TravelPackage p = TravelPackage.builder().name("Package 1").passengerCapacity(2).build();

        Passenger p1 = new StandardPassenger("Harsh", 20, 100.0);

        Activity a1 = new Activity("Slides", "Water Slides for fun", 55.0, 3);

        Destination d1 =
                Destination.builder().name("Wonderla").activities(Arrays.asList(a1)).build();

        p.addDestination(d1);
        p.addPassenger(p1);

        p1.registerForActivity(a1);

        p.printAvailableActivityDetails();

        p.printIndividualPassengerDetails(p1);

        p.printItinerary();

        return;

    }
}
