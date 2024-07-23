package designPattern.behavioral.strategy;

public class StrategegyPatternDemo {

    public static void main(String[] args) {
        Payment payment = new Payment();

        payment.addItem(new Item(1,30));
        payment.addItem(new Item(2,40));
        Item item3 = new Item(3, 50);
        payment.addItem(item3);

        payment.pay(new CreditCard());
        payment.removeItem(item3);

        payment.pay(new DebitCard());

    }
}
