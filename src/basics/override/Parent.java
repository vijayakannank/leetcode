package basics.override;

public class Parent {
    private void m1(){
        System.out.println("m1 form parent");
    }

    protected void m2(){
        System.out.println("m2 from parent");
    }

}

class Child extends Parent{

    private void m1(){}
    @Override
    protected void m2(){
        System.out.println("method form child");
    }

}



