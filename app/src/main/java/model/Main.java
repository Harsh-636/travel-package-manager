package model;

import model.travelpackage.impl.TravelPackage;

public class Main {

    public static void main(String[] args) {
        TravelPackage p = TravelPackage.builder().name("Package 1").passengerCapacity(2).build();
    }
}
