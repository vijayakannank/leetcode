package string;

public class StringCompression {
    public static void main(String[] args) {
        compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'});
    }

    public static int compress(char[] chars) {
        if(chars.length == 1)
            return 1;

        int i =0;
        int n = chars.length;
        int index = 0;

        while(i< n){
            int count = 0;
            char curChar = chars[i];

            while(i<n && curChar == chars[i]){
                i++;
                count++;
            }
            chars[index++] = curChar;
            if(count >1){
                String countStr = count+"";

                for(int j = 0; j<countStr.length();j++){
                    chars[index++] = countStr.charAt(j);
                }
            }


        }

        return index;
    }
}
