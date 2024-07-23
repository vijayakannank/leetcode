package array;

import java.util.*;

public class MergingIntervals {

    public int[][] merge(int[][] intervals) {
        if(intervals.length <2)  return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1; i<intervals.length; i++){
            int[] prev = list.get(list.size()-1);
            if(prev[1] >=  intervals[i][0] && prev[1] >=  intervals[i][1])
                continue;
            else if(prev[1] >=  intervals[i][0])
                prev[1] = intervals[i][1];
            else
                list.add(intervals[i]);
        }

        int[][] result = new int[list.size()][2];
        for(int i=0; i< list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
}
