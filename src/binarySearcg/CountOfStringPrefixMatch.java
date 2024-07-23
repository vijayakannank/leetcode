package binarySearcg;

public class CountOfStringPrefixMatch {
    public static void main(String[] args) {
        String[] strs = {"abc","abcd","abcde","abcde","abcde", "bcde","bcd", "cde", "def", "defg", "defh"};
        CountOfStringPrefixMatch prefixMatch = new CountOfStringPrefixMatch();
        String prefix = "def";
        int wordIndex = prefixMatch.findWordIndex(strs, prefix);
        if(wordIndex == -1)
            System.out.println(0);
        int startIndex =   prefixMatch.findStartIndex(strs, prefix, wordIndex-1);
        int endIndex =  prefixMatch.findEndIndex(strs, prefix, wordIndex+1);
        System.out.println(endIndex-startIndex+1);

    }

    int findWordIndex(String[] strs, String prefix){
        int low = 0;
        int high = strs.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(strs[mid].startsWith(prefix))
                return mid;
            if(isPrefixGreater(strs[mid], prefix))
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
    int findStartIndex(String[] strs, String prefix, int high){
        int low = 0;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(strs[mid].startsWith(prefix)){
                if(mid == 0)
                    return 0;
                if( !strs[mid-1].startsWith(prefix))
                    return mid;
                low = mid+1;
            }
            else if(strs[mid+1].startsWith(prefix)){
                return mid+1;
            }

            else
                low = mid+1;
        }
        return -1;
    }
    int findEndIndex(String[] strs, String prefix, int low){
        int high = strs.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(strs[mid].startsWith(prefix)){
                if(mid == strs.length-1)
                    return strs.length-1;
                if( !strs[mid+1].startsWith(prefix))
                    return mid;
                low = mid+1;
            }
            else if(strs[mid-1].startsWith(prefix))
                return mid-1;
            else
                high = mid-1;
        }
        return -1;
    }


    boolean isPrefixGreater(String word, String prefix){
        for(int i=0; i<prefix.length(); i++){
            if(word.charAt(i) < prefix.charAt(i) )
                return true;
        }
        return false;
    }
}
