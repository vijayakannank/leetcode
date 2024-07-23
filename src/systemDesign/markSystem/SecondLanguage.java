package systemDesign.markSystem;

public class SecondLanguage implements Subject{


    int mark;

    public SecondLanguage(int mark){
        this.mark= mark;
    }

    @Override
    public int getMark() {
        return mark;
    }
}
