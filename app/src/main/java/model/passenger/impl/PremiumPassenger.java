package model.passenger.impl;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import model.Activity;

@Slf4j
public class PremiumPassenger extends Passenger {

    public PremiumPassenger(String name, Long passengerNumber, Double balance,
            Map<Activity, Double> registeredActivities) {
        super(name, passengerNumber, balance, registeredActivities);
    }

    @Override
    public void setBalance(Double value) {
        this.balance = value;
    }

    @Override
    public void registerForActivity(Activity activity) {

        if (activity.getCapacity() <= 0) {
            log.info("Activity {} does not have sufficient capacity to register passenger {}",
                    activity.getName(), this.name);
            return;
        }

        activity.setCapacity(activity.getCapacity() - 1);

        // premium members can register for free
        this.registeredActivities.put(activity, 0.0);
    }

}
