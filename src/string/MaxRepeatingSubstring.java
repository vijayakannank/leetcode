package string;

public class MaxRepeatingSubstring {

    public static void main(String[] args) {

        maxRepeating( "aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba" );
    }

    static int maxRepeating(String sequence, String word) {
        if(sequence.length() < word.length())
            return 0;
        int j = 0;
        int result = 0;
        for(int i = 0; i< sequence.length(); i++){
            if(sequence.charAt(i) == word.charAt(j)){
                j++;
            } else {
                j=0;
            }

            if(j == word.length()){
                result++;
                j=0;
            }
        }
        return result;
    }
}
