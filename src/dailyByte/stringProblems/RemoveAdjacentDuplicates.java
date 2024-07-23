package dailyByte.stringProblems;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println(removeAdjacentDuplicate("a"));
//        StringBuilder sb = new StringBuilder("");
//        System.out.println(sb.charAt(0));

    }
    static String removeAdjacentDuplicate(String str){
        if(str == null || str.length() < 2) return str;
        StringBuilder sb = new StringBuilder(""+str.charAt(0));
        int prev = 0;
        for(int i=1;i<str.length();i++){
            sb.append(str.charAt(i));
            if(sb.charAt(prev) != str.charAt(i)) {
                prev = prev+1;
            } else {
                sb.delete(prev, prev+2);
                prev = prev-1;
            }

        }
        return sb.toString();
    }
}
