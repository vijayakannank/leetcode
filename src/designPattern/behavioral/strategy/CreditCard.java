package designPattern.behavioral.strategy;

public class CreditCard implements PaymentStrategy{


    @Override
    public void pay(int amount) {
        System.out.println("Payment -"+amount+" has been done by creditCard");

    }
}
