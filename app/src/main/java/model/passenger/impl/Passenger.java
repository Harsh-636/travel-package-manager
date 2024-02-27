package model.passenger.impl;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import model.Activity;
import model.passenger.PassengerInterface;

@Data
@AllArgsConstructor
public abstract class Passenger implements PassengerInterface {

    protected String name; 
    protected Long passengerNumber;
    protected Double balance;
    protected Map<Activity, Double> registeredActivities;

    @Override
    public abstract void setBalance(Double value);

    @Override
    public abstract void registerForActivity(Activity activity);
    
}
