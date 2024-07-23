package graph.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 *
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjs.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adjs.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<numCourses; i++){
            if(indegree[i] ==  0)
                queue.add(i);
        }

        int count = 0;

        while(!queue.isEmpty()){
            count++;
            int cur = queue.poll();
            for(int i: adjs.get(cur)){

                if(--indegree[i] == 0)
                    queue.add(i);
            }
        }
        return count == numCourses;

    }
}
