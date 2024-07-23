package designPattern.structural.adapter;

public class MultiRestoApp implements IMultiRestoApp{
    @Override
    public void displayMenu(String xml) {
        System.out.println("MultiRestoApp displaying Menu by using Xml");

    }

    @Override
    public void displayRecomendation(String xml) {
        System.out.println("MultiREstoApp displaying recommendation");

    }
}
