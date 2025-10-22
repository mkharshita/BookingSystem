package service;

import Entity.Driver;
import Entity.Ride;
import Entity.User;

import java.util.List;

public interface IUserService {

    void registerUser(User user);
    void findAllAvaibleDrivers();
    void rideRequest(int userId, int rideId);
    void completeRide(int rideId) ;

}
