package designPattern.behavioral.strategy;

public class Item {
    int code;
    int price;

    public Item(int code, int price) {
        this.code = code;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


}
