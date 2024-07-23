package dailyByte.stringProblems;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"ab", "a"};
        System.out.println(findLongestCommonPrefix(str));
    }
    static String findLongestCommonPrefix(String[] strs) {

        if(strs.length == 0){
            return "";
        }else if(strs.length == 1){
            return strs[0];
        }

        String reference = strs[0];
        StringBuilder commonPrefix = new StringBuilder();

        for(int j=0; j<reference.length(); j++){
            for(int i=1; i<strs.length; i++){
                if( j >= strs[i].length() || ( reference.charAt(j) != strs[i].charAt(j)) ){
                    return commonPrefix.toString();
                }
            }

            commonPrefix.append(reference.charAt(j));

        }

        return commonPrefix.toString();

    }
}
