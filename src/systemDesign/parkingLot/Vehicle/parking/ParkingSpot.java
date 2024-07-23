package systemDesign.parkingLot.Vehicle.parking;

import systemDesign.parkingLot.Vehicle.Vehicle;

public class ParkingSpot {

    String id;
    ParkingSpotType type;

    Vehicle assignedVehicle;

    boolean isFree;

    ParkingSpot(String id, ParkingSpotType type){
        this.id = id;
        this.type = type;
    }

    void assignVehicle(Vehicle vehicle){
        assignedVehicle = vehicle;
        isFree = false;
    }

    void vacateSpot(){
        assignedVehicle = null;
        isFree = true;
    }

}
