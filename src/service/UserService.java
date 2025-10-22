package service;

import Entity.Driver;
import Entity.Ride;
import Entity.User;
import Repo.DriverRepo;
import Repo.RideRepo;
import Repo.UserRepo;

import java.util.List;
import Exception.*;
public class UserService implements IUserService{

    UserRepo userRepo = UserRepo.getInstance();
    DriverRepo driverRepo = DriverRepo.getInstance();
    RideRepo rideRepo = RideRepo.getInstance();
    IBookingService bookingService = BookingService.getInstance();

    private static UserService instance;

    private UserService() {
        this.userRepo = UserRepo.getInstance();
        this.driverRepo = DriverRepo.getInstance();
        this.rideRepo = RideRepo.getInstance();
        this.bookingService = BookingService.getInstance();
    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }

    @Override
    public void registerUser(User user) {
        userRepo.save(user);
        System.out.println("User registered successfully : " + user.getName());

    }

    @Override
    public void findAllAvaibleDrivers() {
        List<Driver> avaibleDrivers = bookingService.findAllAvaibleDrivers();
        System.out.println("Available Drivers: " + avaibleDrivers);
    }

    @Override
    public void rideRequest(int userId, int rideId) {

        try {
           Ride ride = bookingService.rideRequest(userId,rideId);
            System.out.println("Ride Request Completed:" + rideId);

        } catch (NoDriverAvailableException e) {
            System.out.println("No Driver Available, Ride Request Failed");
        }

    }

    @Override
    public void completeRide(int rideId) {
        System.out.println("Ride Completed " + rideId);
        bookingService.completeRide(rideId);
    }
}
