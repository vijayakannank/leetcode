package designPattern.structural.facade;

public class FacadeDemo {

    public static void main(String[] args) {
        ShopKeeper shopKeeper = new ShopKeeper();
        shopKeeper.iPhoneSale();
        shopKeeper.oppoSale();
    }
}
