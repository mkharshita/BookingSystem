package Entity;

import java.time.Instant;

public class Ride {
    private int id;
    private int userId;
    private int driverId;
    private Instant startTime;
    private Instant endTime;
    private RideStatus status;
    public Ride(int id, int userId, int driverId) {
        this.id =id;
        this.userId = userId;
        this.driverId = driverId;
        this.status = RideStatus.REQUESTED;
    }

    public void start(){
        this.startTime = Instant.now();
        this.status = RideStatus.ONGOING;
    }

    public void complete(){
        this.endTime = Instant.now();
        this.status = RideStatus.COMPLETED;
    }

    public RideStatus getStatus() {
        return status;
    }
    public int getDriverId() {
        return driverId;
    }


}
