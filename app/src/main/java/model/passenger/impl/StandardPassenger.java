package model.passenger.impl;

import model.Activity;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StandardPassenger extends Passenger {

    public StandardPassenger(String name, Long passengerNumber, Double balance,
            Map<Activity, Double> registeredActivities) {
        super(name, passengerNumber, balance, registeredActivities);
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

        activity.setCapacity(activity.getCapacity() - 1);
        // add to registered activities
        registeredActivities.put(activity, activity.getCost());

        // subtract cost from passenger's balance
        this.setBalance(this.balance - activity.getCost());
    }

}
