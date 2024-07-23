package designPattern.creational.abstractfactory;

public class MSIMonitor implements Monitor{
    @Override
    public void assemble() {
        System.out.println("Msi monitor");
    }
}
