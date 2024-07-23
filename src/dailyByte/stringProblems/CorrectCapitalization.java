package dailyByte.stringProblems;

public class CorrectCapitalization {
    public static void main(String[] args) {
        System.out.println(isCaptilized("india"));

    }
    static boolean isCaptilized(String str) {
        int count =0;
        for(int i=0; i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))) count++;
        }
        return count == str.length() || count == 0 || (count == 1 && Character.isUpperCase(str.charAt(0)));
    }
}
