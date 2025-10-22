package service;

import Entity.Driver;
import Repo.DriverRepo;

import java.util.Optional;

public class DriverService implements IDriverService {

    private DriverRepo driverRepo;
    private static DriverService instance;
    private DriverService() {
        driverRepo = DriverRepo.getInstance();
    }
    public static DriverService getInstance() {
        if (instance == null) {
            synchronized (DriverService.class) {
                if (instance == null) {
                    instance = new DriverService();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean updateStatus(int id) {
        return false;
    }
}
