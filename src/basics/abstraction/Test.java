package basics.abstraction;

public class Test{
    public static void main(String[] args) {
        HmToMile hm = new Naughty();
        // Naughty ny = new HmToMile();
        Throwable tl = new Exception("dssd");

    }


}

class HmToMile {
    int convert(int km){
        return getMile() *km;
    }
    int getMile(){
        return 2;
    }
}

class Naughty extends HmToMile {
    @Override
    int getMile() {
        return 3;
    }

    int ownMethod(){ return 2;}
}



