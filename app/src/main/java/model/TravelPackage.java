package model;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import model.passenger.impl.Passenger;

@Data
@Builder
public class TravelPackage {
    String name;
    Integer passengerCapacity;
    List<Destination> itinerary;
    List<Passenger> passengers;
}
