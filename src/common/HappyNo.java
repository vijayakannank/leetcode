package common;

import java.util.HashSet;
import java.util.Set;

public class HappyNo {

    public static void main(String[] args) {
        isHappy(19);
    }

    static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while(n != 1){
            while(n !=0){
                int lastDigit = n%10;
                sum += n%10*n%10;
                n = n/10;
            }
            if(sum == 1 || set.contains(sum))
                break;
            set.add(sum);
            n = sum;
            sum = 0;
        }
        return sum == 1;
    }
}
