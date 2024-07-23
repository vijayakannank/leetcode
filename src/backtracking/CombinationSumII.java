package backtracking;


/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        new CombinationSumII().combinationSum2(arr, 5);
    }
    List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, 0,0, target, new ArrayList<>(), result);
        return result;

    }

    void backtrack(int[] candidates, int sum, int curr, int target, List<Integer> list, List<List<Integer>> result){
        if(sum > target)
            return;
        if(sum == target && !result.contains(list)){
            result.add(new ArrayList<>(list));
            return;

        }

        for(int i= curr; i< candidates.length; i++){
            if(i > curr && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            backtrack(candidates, sum+candidates[i], i+1, target, list, result);
            list.remove(list.size()-1);
        }
    }
}
