package dailyByte.stringProblems;

/**
 * we can delete atmost one charector to make polindrome
 */
public class ValidPolindrom2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("cabba"));
    }

    static  boolean validPalindrome(String s){
        int i = 0;
        int j= s.length()-1;

        while (i<j){
            if(s.charAt(i) != s.charAt(j))
                return isPolindrome(s, i+1,j) || isPolindrome(s,i, j-1);
            i++;
            j--;
        }
        return true;
    }

    static boolean isPolindrome(String s, int i, int j) {
        while (i<j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
