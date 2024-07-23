package designPattern.behavioral.Visitor;

public class VehicleService {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[]{
                new Car("Black", 2010),
                new Van(5000, 6),
                new Motorbike(100, "TVS")
        };

        VehicleInspector inspector = new VehicleInspection();
        int total = 0;
        for(Vehicle vehicle : vehicles){
            total = total + vehicle.accept(inspector);
        }
        System.out.println(total);
    }
}
