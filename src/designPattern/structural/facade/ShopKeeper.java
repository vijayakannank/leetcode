package designPattern.structural.facade;

public class ShopKeeper {

    private IPhone iPhone;
    private Samsung samsung;
    private Oppo oppo;

    public ShopKeeper(){
        this.iPhone  = new IPhone();
        this.samsung = new Samsung();
        this.oppo = new Oppo();
    }

    void iPhoneSale(){
        this.iPhone.modelNo();
        this.iPhone.price();
    }

    void oppoSale(){
        this.oppo.modelNo();
        this.oppo.price();
    }

    void samsungSale(){
        this.samsung.modelNo();
        this.samsung.price();
    }
}
