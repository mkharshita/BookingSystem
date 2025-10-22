package service;

import Entity.Driver;
import Entity.Ride;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import Entity.User;
import Exception.NoDriverAvailableException;
import Exception.NoRideFoundException;
import Repo.DriverRepo;
import Repo.RideRepo;
import Repo.UserRepo;

public class BookingService implements IBookingService {

    private static BookingService instance;

    private final UserRepo userRepo;
    private final DriverRepo driverRepo;
    private final RideRepo rideRepo;


    private BookingService() {
        userRepo = UserRepo.getInstance();
        driverRepo = DriverRepo.getInstance();
        rideRepo = RideRepo.getInstance();
    }

    public static BookingService getInstance() {
        if (instance == null) {
            synchronized (BookingService.class) {
                if (instance == null) {
                    instance = new BookingService();
                }
            }
        }
        return instance;
    }


    @Override
    public Ride rideRequest(int userId, int rideId) throws NoDriverAvailableException {
        Optional<User> userO = userRepo.findById(userId);
        User user = userO.get();
        List<Driver> availableDrivers = driverRepo.findAllAvailableDrivers();
        if(availableDrivers.isEmpty()){
            throw new NoDriverAvailableException("No driver available");
        }
        Driver driver = availableDrivers.get(0);
        driver.setAvailable(false);

        driverRepo.save(driver);
        Ride ride = new Ride(rideId,userId, driver.getId());
        ride.start();

        rideRepo.save(rideId,ride);
        return ride;

    }

    @Override
    public void completeRide(int rideId) throws NoRideFoundException {
        Optional<Ride> rideOptional = rideRepo.getRide(rideId);
        Ride ride = rideOptional.get();
        ride.complete();
        rideRepo.save(rideId,ride);
        Optional<Driver> driverOptional = driverRepo.findById(ride.getDriverId());
        Driver driver = driverOptional.get();
        driver.setAvailable(true);

        driverRepo.save(driver);
    }

    @Override
    public List<Driver> findAllAvaibleDrivers() {
        return driverRepo.findAllAvailableDrivers();
    }
}
