package designPattern.structural.facade;

public class Samsung implements Phone{
    @Override
    public String modelNo() {
        return "Samsung 1";
    }

    @Override
    public int price() {
        return 232;
    }
}
