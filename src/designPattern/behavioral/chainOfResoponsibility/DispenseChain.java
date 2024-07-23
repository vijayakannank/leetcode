package designPattern.behavioral.chainOfResoponsibility;

public interface DispenseChain {

    void setNextChain(DispenseChain chain);

    void dispense(Currency currency);
}
