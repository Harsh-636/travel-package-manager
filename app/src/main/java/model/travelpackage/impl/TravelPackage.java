package model.travelpackage.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Activity;
import model.Destination;
import model.passenger.impl.GoldPassenger;
import model.passenger.impl.Passenger;
import model.passenger.impl.StandardPassenger;
import model.travelpackage.TravelPackageInterface;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class TravelPackage implements TravelPackageInterface {

    private String name;
    private Integer passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    @Override
    public void printItinerary() {

        log.info("Printing itinerary for travel package {}", this.name);
        System.out.println("Package Name : " + this.name);
        this.itinerary.stream().forEach(destination -> {
            System.out.println("Destination : " + destination.getName());
            destination.getActivities().stream().forEach(activity -> {
                System.out.println("\tActivity : " + activity.getName());
                System.out.println("\tCost : " + activity.getCost());
                System.out.println("\tCapacity : " + activity.getCapacity());
                System.out.println("\tDescription : " + activity.getDescription());
            });
        });
    }

    @Override
    public void printPassengerDetails() {

        log.info("Printing passenger details for travel package {}", this.name);
        System.out.println("Package Name : " + this.name);
        System.out.println("Passenger Capacity : " + this.passengerCapacity);
        System.out.println("No. of passengers enrolled : " + this.passengers.size());
        System.out.println("Passenger Details : ");
        passengers.stream().forEach(p -> {
            System.out.println("\tName : " + p.getName());
            System.out.println("\tNumber : " + p.getPassengerNumber() + "\n");
        });
    }

    @Override
    public void printIndividualPassengerDetails(Passenger passenger) {

        log.info("Printing individual passenger details for travel package {}", this.name);

        System.out.println("Name : " + passenger.getName());
        System.out.println("Passenger Number : " + passenger.getPassengerNumber());

        if (passenger.getClass() == StandardPassenger.class
                || passenger.getClass() == GoldPassenger.class) {
            System.out.println("Balance : " + passenger.getBalance());
        }

        System.out.println("Registered Activities : ");
        passenger.getRegisteredActivities().forEach((activity, price) -> {
            System.out.println("\tActivity Name : " + activity.getName());
            System.out.println("\tDestination : " + findDestination(activity).getName());
            System.out.println("\tPrice Paid : " + price);
        });
    }

    @Override
    public void printAvailableActivityDetails() {

        log.info("Printing details for available activities for travel package {}", this.name);

        itinerary.forEach(destination -> {
            if (destination.getActivities() == null || destination.getActivities().isEmpty()) {
                return;
            }

            destination.getActivities().stream()
                    .filter(activity -> activity.getCapacity() > 0)                                     // filtering out activities with available capacity
                    .forEach(activity -> {
                        System.out.println("\tActivity Name : " + activity.getName());
                        System.out.println("\tActivity Description : " + activity.getDescription());
                        System.out.println("\tActivity Cost : " + activity.getCost());
                        System.out.println("\tAvailable Capacity : " + activity.getCost());
                    });

        });
    }

    @Override
    public void addDestination(Destination destination) {
        this.itinerary.add(destination);
    }

    @Override
    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    private Destination findDestination(Activity activity) {
        return itinerary.stream()
                .filter(destination -> destination.getActivities().contains(activity)).findFirst()
                .orElse(null);
    }



}

