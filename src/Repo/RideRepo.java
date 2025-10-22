package Repo;

import Entity.Ride;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RideRepo {
    private Map<Integer, Ride> rides;
    private static RideRepo instance;
    private RideRepo(){
        rides = new HashMap<>();
    }
    public static RideRepo getInstance(){
        if(instance == null){
            synchronized (RideRepo.class){
                if(instance == null){
                    instance = new RideRepo();
                }
            }
        }
        return instance;
    }

    public void save(int rideId, Ride ride) {
        rides.put(rideId, ride);
    }

    public List<Ride> getAllRides() {
        return (List<Ride>) rides.values();
    }

    public Optional<Ride> getRide(int rideId) {
        return Optional.ofNullable(rides.get(rideId));
    }
}
