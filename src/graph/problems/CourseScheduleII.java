package graph.problems;

import java.util.*;
/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 *
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseScheduleII {

    int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>>  map = new HashMap<>();
        int[] res = new int[numCourses];
        int[] req = new int[numCourses];

        for(int[] arr: prerequisites){
            List<Integer> list = map.getOrDefault(arr[1], new ArrayList<>());
            list.add(arr[0]);
            map.put(arr[1], list);
            req[arr[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(req[i] == 0)
                queue.offer(i);
        }

        if(queue.isEmpty())
            return new int[]{};

        int k = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            res[k++] = cur;
            if(map.containsKey(cur)){
                for(int i: map.get(cur)){
                    req[i]--;
                    if(req[i] == 0)
                        queue.offer(i);
                }
            }
        }

        return k == numCourses ? res: new int[]{};
    }
}
