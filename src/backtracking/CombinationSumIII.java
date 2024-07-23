package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIII c = new CombinationSumIII();
        System.out.println(c.combinationSum3(3, 9));
    }
    List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, new ArrayList<>(), result, 0, 1);
        return result;
    }

     void backtrack(int k, int n, List<Integer> list, List<List<Integer>> result, int sum, int index){
        if(list.size() == k && sum == n){
            result.add(new ArrayList<>(list));
            return;
        }
        if(list.size() >= k || sum >= n)
            return;
        for(int i=index; i<10; i++){
            list.add(i);
            backtrack(k,n, list, result, sum+i, i+1);
            list.remove(list.size()-1);
        }

    }
}
