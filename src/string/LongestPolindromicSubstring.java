package string;

public class LongestPolindromicSubstring {

    static int longestPalindrome(String s, int i, int j){

        while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }

    public static void main(String[] args) {
        String str = "aabba";
        int s = 0;
        int e = 0;
        for(int i=0; i<str.length()-1; i++){
            int len1 = longestPalindrome(str, i, i);
            int len2 = longestPalindrome(str, i, i+1);
            int len = Math.max(len1, len2);
            if(len > e-s ){
                s = i- (len-1)/2;
                e = i+ (len)/2;
            }

        }
        System.out.println(str.substring(s, e+1));
    }
}
