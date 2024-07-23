package backtracking;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();
        getparanthesis(ans,new StringBuilder(),0,0,n);
        return ans;
    }
    public void getparanthesis(List<String>ans,StringBuilder curr,int close,int open,int max){
        System.out.println("o -"+open+" c"+close+" s "+curr.toString());
        if(curr.length() == max*2){
            ans.add(curr.toString());
            return;

        }
        if(open < max){
            curr.append("(");
            getparanthesis(ans,curr,close,open+1,max);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close < open){
            curr.append(")");
            getparanthesis(ans,curr,close+1,open,max);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
