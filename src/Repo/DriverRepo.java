package Repo;

import Entity.Driver;

import java.util.*;

public class DriverRepo {
    private Map<Integer, Driver> drivers;
    private static DriverRepo instance;
    private DriverRepo() {
        drivers = new HashMap<>();
    }
    public static DriverRepo getInstance() {
        if (instance == null) {
            synchronized (DriverRepo.class) {
                if (instance == null) {
                    instance = new DriverRepo();
                }
            }
        }
        return instance;
    }

    public Driver save(Driver driver) {
        drivers.put(driver.getId(), driver);
        return driver;
    }
    public Optional<Driver> findById(int driver) {
        return Optional.ofNullable(drivers.get(driver));
    }

    public List<Driver> findAllAvailableDrivers() {
        List<Driver> availableDriver = new ArrayList<>();
        for(Driver d:drivers.values())
            if(d.isAvailable())
                availableDriver.add(d);
        return availableDriver;
    }


}
