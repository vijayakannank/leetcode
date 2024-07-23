package designPattern.behavioral.Iterator;

import java.util.Arrays;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository(
                Arrays.asList("vijay", "kannan", "vj")
        );

        for(Iterator it = namesRepository.getIterator(); it.hasNext();){
            System.out.println(it.next());
        }

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);

        }
    }
}
