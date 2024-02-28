package model.passenger.impl;

import java.util.Map;
import java.util.HashMap;
import lombok.Data;
import model.Activity;
import model.passenger.PassengerInterface;

@Data
public abstract class Passenger implements PassengerInterface {

    private String name;
    private Integer passengerNumber;
    private Double balance;
    private Map<Activity, Double> registeredActivities = new HashMap<>();

    @Override
    public abstract void setBalance(Double value);

    @Override
    public abstract void registerForActivity(Activity activity);
}
