package model.passenger.impl;

import java.util.Map;
import java.util.HashMap;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import model.Activity;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
public class PremiumPassenger extends Passenger {

    private String name;
    private Integer passengerNumber;
    private Map<Activity, Double> registeredActivities = new HashMap<>();

    public PremiumPassenger(String name, Integer passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
    }

    @Override
    public void setBalance(Double value) {
        System.out.println("Premium Passengers do not have a balance!");
        return;
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
