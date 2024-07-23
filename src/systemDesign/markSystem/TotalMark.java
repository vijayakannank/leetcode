package systemDesign.markSystem;

import java.util.Arrays;
import java.util.List;

public class TotalMark {

    public static void main(String[] args) {
        List<Subject> student1Marks = Arrays.asList(
                new Language(60),
                new SecondLanguage(50),
                new Maths(90),
                new Science(15, 60)
        );
        System.out.println(new TotalMark().getTotalMark(student1Marks));
    }


    int getTotalMark(List<Subject> subjects){

        int total = 0;
        for(Subject subject: subjects){
            total += subject.getMark();
        }
        return total;
    }
}
