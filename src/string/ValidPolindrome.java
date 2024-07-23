package string;

public class ValidPolindrome {

    public static void main(String[] args) {
        isPalindrome(".,");
    }

    static  boolean isPalindrome(String s) {

        if(s == null) return false;
        if(s.isEmpty()) return true;

        int i =0;
        int j= s.length()-1;
        s = s.toLowerCase();

        while(i<j){
            if(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
