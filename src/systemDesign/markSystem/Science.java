package systemDesign.markSystem;

public class Science implements Subject{

    int practicalMark;
    int theoryMark;

    public Science(int practicalMark, int theoryMark){
        this.practicalMark = practicalMark;
        this.theoryMark = theoryMark;
    }

    @Override
    public int getMark() {
        return theoryMark+practicalMark;
    }
}
