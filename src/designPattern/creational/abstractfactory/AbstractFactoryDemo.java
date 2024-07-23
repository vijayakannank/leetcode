package designPattern.creational.abstractfactory;

public class AbstractFactoryDemo {

    public static void main(String[] args) {

        Company manufacturer = new
                MSIManufacturer();

        manufacturer.createCpu().assemble();
        manufacturer.createMonitor().assemble();

        Company manufacturer1 = new AsusManufacturer();
        manufacturer1.createCpu().assemble();
        manufacturer1.createMonitor();
    }
}
