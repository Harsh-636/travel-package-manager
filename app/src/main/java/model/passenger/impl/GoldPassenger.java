package model.passenger.impl;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import model.Activity;

@Slf4j
public class GoldPassenger extends AbstractPassenger {

    public GoldPassenger(String name, Long passengerNumber, Double balance,
            Map<Activity, Double> registeredActivities) {
        super(name, passengerNumber, balance, registeredActivities);
    }

    @Override
    public void setBalance(Double value) {
        this.balance = value;
    }

    @Override
    public void registerForActivity(Activity activity) {
        // find discounted cost for gold passenger
        Double discountedCost = (0.9) * activity.getCost();

        // check if passenger has sufficient balance before registering for an activity
        if (discountedCost > this.balance) {
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
        this.registeredActivities.put(activity, discountedCost);

        // update passenger's balance
        this.setBalance(this.balance - discountedCost);

    }

}
