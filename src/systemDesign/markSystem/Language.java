package systemDesign.markSystem;

public class Language implements Subject{

    int mark;
    Language(int mark){
        this.mark  = mark;
    }

    @Override
    public int getMark() {
        return this.mark;
    }
}
