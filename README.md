System Design Exercise: Cab Booking App (Simplified)

Objective

Design a basic simulation of a cab booking system using object-oriented programming principles. The goal is to evaluate your ability to structure code in a modular, extensible, and logically organized way.



Scenario

You are tasked with designing a simplified cab booking system where:

Users can register.
Users can view available drivers.
Users can book a ride.
If no driver is available, the booking should fail gracefully.
This is a simulation, not a real application. You are not expected to write actual APIs or integrate with databases.



Implementation Guidelines

Driver Class (Main Class)

Acts as the entry point of the application.
Simulates the frontend using print statements.
No need to take input from the console.
Should invoke methods from service classes to simulate flows.
Data Storage

Use in-memory variables (e.g., arrays, lists) to simulate a database.
No need to use MySQL or any external storage.
Class Design Expectations

Structure your code into POJOs, services, and repositories (if needed).
Focus on modularity and separation of concerns.
Avoid unnecessary complexity like interfaces or inheritance unless absolutely needed.
Ensure that dependencies between classes are logical and minimal.
Functional Requirements

User Registration

Simulate adding a user to the system.
View Available Drivers

Display a list of drivers who are currently available.
Driver availability can be hardcoded or toggled via a method.
Book Ride

A user can request a ride.
If a driver is available, assign the driver and mark them as unavailable.
If no driver is available, print an appropriate message and do not book the ride.
System-Level Thinking

Ensure that once a driver is assigned, they are marked unavailable.
A driver becomes available again only after a simulated ride completion (optional).
Bookings should be associated with both the user and the driver.
Evaluation Criteria

You will be evaluated on:

Class Segregation: Are responsibilities clearly divided among classes?
Modularity: Can the system be extended easily?
Logical Dependencies: Are classes dependent on the right components?
Code Readability: Is the code easy to follow?
System Thinking: Does the solution simulate realistic behavior?




Bonus Functionalities (Optional)

Allow drivers to mark themselves available/unavailable.
Simulate ride completion and re-availability of drivers.
Track ride history per user.




Example Corner Case to Consider

A user tries to book a ride when no drivers are available.
Expected behavior: The system should not book the ride and should notify the user that no drivers are available.








User:
id, name

Driver:
id, name, available

Ride:
id, userId, driverId, startedAt, endedAt, status

UserRepo
Map<Integer, User>
save()
findById()

driverRepo
Map<Integer, Driver>
save()
findById()
findAllAvaibleDrivers()


IBookingService
Ride rideRequest(long userId) throws NoDriverAvailableException
completeRide(long rideId) throws NoRideFoundException
List<Driver> findAllAvaibleDrivers();















