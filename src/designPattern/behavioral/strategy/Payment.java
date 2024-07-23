package designPattern.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class Payment {

    List<Item> items;

    Payment(){
        this.items = new ArrayList<>();
    }

    void addItem(Item item){
        this.items.add(item);

    }

    void removeItem(Item item){
        this.items.remove(item);
    }

    int calculateTotalPrice(){
        int price =0;
        for(Item item: this.items){
            price += item.price;
        }
        return price;
    }

    void pay(PaymentStrategy strategy){
        int total = this.calculateTotalPrice();
        strategy.pay(total);
    }
}
