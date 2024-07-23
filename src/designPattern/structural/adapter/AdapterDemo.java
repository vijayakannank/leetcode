package designPattern.structural.adapter;

public class AdapterDemo {

    public static void main(String[] args) {
        IMultiRestoApp oldUi = new MultiRestoApp();
        oldUi.displayMenu("xml");

        FancyUIServiecAdapter fancyUIServiecAdapter = new FancyUIServiecAdapter(new FancyUiServie());
        fancyUIServiecAdapter.displayMenu("xml");

    }
}
