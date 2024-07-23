package common;

public class NoOfMatches {

    public static void main(String[] args) {
         numberOfMatches(7);
    }
    static int numberOfMatches(int n) {

        int result = 0;

        while(n > 1){
            result += n/2;
            if(n%2 == 1){
                n = (n/2)+1;
            } else {
                n = n/2;
            }

        }
        return result;
    }
}
