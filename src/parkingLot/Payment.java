package parkingLot;

public class Payment {

    void pay(PaymentStrategy strategy, int amount){
        strategy.pay(amount);
    }
}
