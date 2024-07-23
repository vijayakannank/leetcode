package designPattern.creational.abstractfactory;

public  class AsusManufacturer  extends Company{

    @Override
    CPU createCpu() {
        return new AsusCPU();
    }

    @Override
    Monitor createMonitor() {
        return new ASUSMonitor();
    }
}
