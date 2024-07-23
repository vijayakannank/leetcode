package array;

import java.util.HashMap;

/**
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 *
 *
 *
 * Example 1:
 *
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 *
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 *
 * Constraints:
 *
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 *
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */

public class PairsofSongsWithTotalDurationsDivisibleby60 {
    public static void main(String[] args) {
        new PairsofSongsWithTotalDurationsDivisibleby60().numPairsDivisibleBy60(new int[] {30,20,150,100,40});
    }
    int numPairsDivisibleBy60(int[] time) {
        int count=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<time.length;i++)
        {
            int div=time[i]%60;
            if(hm.containsKey(60-div))
            {
                count+=hm.get(60-div);
            }
            if(div==0)
                hm.put(60,hm.getOrDefault(60,0)+1);
            else
                hm.put(div,hm.getOrDefault(div,0)+1);
        }
        return count;
    }
}
