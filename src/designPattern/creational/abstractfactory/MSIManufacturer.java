package designPattern.creational.abstractfactory;

public class MSIManufacturer extends Company{
    @Override
    CPU createCpu() {
        return new MsiCPU();
    }

    @Override
    Monitor createMonitor() {
        return new MSIMonitor();
    }
}
