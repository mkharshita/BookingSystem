import Entity.Driver;
import Entity.Ride;
import Entity.User;
import Repo.DriverRepo;
import Repo.RideRepo;
import Repo.UserRepo;
import service.BookingService;
import service.IBookingService;
import Exception.NoRideFoundException;
import Exception.NoDriverAvailableException;
import service.IUserService;
import service.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws NoDriverAvailableException {
        System.out.println("Welcome to the Ride Finder");


        DriverRepo driverRepo = DriverRepo.getInstance();

        IUserService userService = UserService.getInstance();

        User user1 = new User(1,"Harshita");
        User user2 = new User(2, "Rahul");

        userService.registerUser(user1);
        userService.registerUser(user2);

        Driver driver1 = new Driver(1,"Shruti", true);
        Driver driver2 = new Driver(2,"Kajal", true);
        driverRepo.save(driver1);
        driverRepo.save(driver2);


        userService.findAllAvaibleDrivers();

        userService.rideRequest(user1.getId(),1);

        userService.findAllAvaibleDrivers();


        userService.rideRequest(user2.getId(),2);


        userService.findAllAvaibleDrivers();

        User user3 = new User(2, "Sakshi");
        userService.registerUser(user3);
        userService.rideRequest(user3.getId(),3);


    }
}