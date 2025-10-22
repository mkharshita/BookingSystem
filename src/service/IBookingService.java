package service;

import Entity.Driver;
import Entity.Ride;

import java.util.List;
import Exception.NoDriverAvailableException;
import Exception.NoRideFoundException;

public interface IBookingService {
    Ride rideRequest(int userId,int rideId) throws NoDriverAvailableException;
    void completeRide(int rideId) throws NoRideFoundException;
    List<Driver> findAllAvaibleDrivers();
}
