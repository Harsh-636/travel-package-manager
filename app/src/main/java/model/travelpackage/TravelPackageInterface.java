package model.travelpackage;

import model.Destination;
import model.passenger.impl.Passenger;

public interface TravelPackageInterface {
    void addDestination(Destination destination);

    void addPassenger(Passenger passenger);

    void printItinerary();

    void printPassengerDetails();

    void printIndividualPassengerDetails(Passenger passenger);

    void printAvailableActivityDetails();
}