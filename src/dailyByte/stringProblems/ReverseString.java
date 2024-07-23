package dailyByte.stringProblems;

public class ReverseString {

    public static void main(String[] args) {
        String str = "vijaya kannan k";
        System.out.println(reverse(str));
    }

    static String reverse(String str){
        if(str == null || str.length() <2) return str;
        StringBuilder result = new StringBuilder("");
        for(int i = str.length()-1; i >= 0; i-- ){
            result.append(str.charAt(i));   
        }
        return result.toString();
    }
}
