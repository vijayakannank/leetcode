package systemDesign.markSystem;

public class Maths implements Subject{

    int mark;

    public Maths(int mark){
        this.mark = mark;
    }

    @Override
    public int getMark() {
        return mark;
    }
}
