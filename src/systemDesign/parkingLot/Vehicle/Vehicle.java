package systemDesign.parkingLot.Vehicle;

public abstract class Vehicle {
    private String licenseNo;

    VehicleType type;


    public Vehicle(String licenseNo, VehicleType type) {
        this.licenseNo = licenseNo;
        this.type = type;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public VehicleType getType() {
        return type;
    }
}
