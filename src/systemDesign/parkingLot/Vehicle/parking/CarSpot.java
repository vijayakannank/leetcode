package systemDesign.parkingLot.Vehicle.parking;

public class CarSpot extends ParkingSpot{
    CarSpot(String id) {
        super(id, ParkingSpotType.CAR);
    }
}
