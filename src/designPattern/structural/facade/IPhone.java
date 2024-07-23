package designPattern.structural.facade;

public class IPhone implements Phone{
    @Override
    public String modelNo() {
        return "Iphone 1";
    }

    @Override
    public int price() {
        return 38398;
    }
}
