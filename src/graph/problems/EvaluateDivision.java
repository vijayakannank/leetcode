package graph.problems;

import java.util.*;
/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 *
 * https://leetcode.com/problems/evaluate-division/
 */
public class EvaluateDivision {

    private Map<String, Map<String, Double>> map;

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));
        double[] values= {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","a"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));
        new EvaluateDivision().calcEquation(equations, values, queries);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        map = new HashMap<>();
        for(int i = 0;i < values.length;i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            map.get(a).put(b, values[i]); // a/b = values[i];
            map.get(b).put(a, (1/values[i])); // b/a = 1/values[i]
        }
        for(int i = 0;i < queries.size();i++){
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);
            if(!map.containsKey(numerator) || !map.containsKey(denominator)){
                res[i] = -1.0;
                continue;
            }
            Set<String> vis = new HashSet<>();
            res[i] = dfs(numerator, denominator, 1, vis);
            if(res[i] != -1){
                map.get(numerator).put(denominator, res[i]);
                map.get(denominator).put(numerator, 1/res[i]);
            }
        }
        return res;
    }

    private double dfs(String curr, String target, double val, Set<String> vis){
        if(curr.equals(target))
            return val;
        if(vis.contains(curr) || curr==null)
            return -1;
        vis.add(curr);
        Map<String, Double> nei = map.get(curr);
        for(Map.Entry<String, Double> entry : nei.entrySet()){
            double tmp = dfs(entry.getKey(), target, val*entry.getValue(), vis);
            if(tmp != -1)
                return tmp;
        }
        return -1;
    }
}
