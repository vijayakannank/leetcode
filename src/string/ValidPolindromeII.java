package string;


// we can delete at most one charector
public class ValidPolindromeII {

    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    static boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length()-1;
        int deleted = 0;

        while(deleted < 2 && i<j){

            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else if(s.charAt(i+1) == s.charAt(j)){
                i++;
                deleted += 1;
            }
            else if(s.charAt(i) == s.charAt(j-1)){
                j--;
                deleted += 1;
            }

        }
        return deleted < 2;

    }
}
