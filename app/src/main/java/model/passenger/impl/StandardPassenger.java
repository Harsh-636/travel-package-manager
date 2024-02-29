package model.passenger.impl;

import java.util.Map;
import java.util.HashMap;
import model.Activity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
public class StandardPassenger extends Passenger {

    private String name;
    private Integer passengerNumber;
    private Double balance;
    private Map<Activity, Double> registeredActivities = new HashMap<>();

    public StandardPassenger(String name, Integer passengerNumber, Double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
    }

    @Override
    public void setBalance(Double value) {
        this.balance = value;
    }

    @Override
    public void registerForActivity(Activity activity) {
        // check if passenger has sufficient balance before registering for an activity
        if (activity.getCost() > this.balance) {
            log.info("Passenger {} does not have sufficient balance to register for {}", this.name,
                    activity.getName());
            return;
        }

        if (activity.getCapacity() <= 0) {
            log.info("Activity {} does not have sufficient capacity to register passenger {}",
                    activity.getName(), this.name);
            return;
        }

        // add to registered activities
        registeredActivities.put(activity, activity.getCost());

        // keeping these at the end to ensure atomicity of registering operation
        // reducing capacity
        activity.setCapacity(activity.getCapacity() - 1);
        // subtract cost from passenger's balance
        this.setBalance(this.balance - activity.getCost());
    }

}
