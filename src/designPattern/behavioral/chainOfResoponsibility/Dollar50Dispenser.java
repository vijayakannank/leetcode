package designPattern.behavioral.chainOfResoponsibility;

public class Dollar50Dispenser implements DispenseChain{
    DispenseChain nextChain;
    @Override
    public void setNextChain(DispenseChain chain) {
        this.nextChain = chain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 50){
            int num = cur.getAmount()/50;
            int remainder = cur.getAmount() % 50;
            System.out.println("Dispensing "+num+" 50$ note");
            if(remainder !=0) this.nextChain.dispense(new Currency(remainder));
        }else{
            this.nextChain.dispense(cur);
        }
    }
}
