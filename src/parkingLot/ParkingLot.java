package parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    List<ParkingSpot> availableSpot = new ArrayList<>();
    List<ParkingSpot> parkedSpot = new ArrayList<>();
    Payment payment = new Payment();


    VehicleType detectVehicleType(){
        //
        return null;
    }

    int findFreeSpot(VehicleType type){return 0;}

    void assignSpot(VehicleType type, int spotId){
        findFreeSpot(type);
        // assign spot
        issueTicket(type, spotId);
    }

    void vacoteSpote(int spotId){
        pay();
        //
    }


    private String issueTicket(VehicleType type, int spotId){
        return "";
    }

    private void pay(){
        payment.pay(null, 0);
    }
}
