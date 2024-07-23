package designPattern.structural.facade;

public class Oppo implements Phone{
    @Override
    public String modelNo() {
        return "Oppo 1";
    }

    @Override
    public int price() {
        return 3241234;
    }
}
