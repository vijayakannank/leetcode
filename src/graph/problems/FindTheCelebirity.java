package graph.problems;

/**
 * Suppose you are at a party with n people (labeled from 0 to n — 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n — 1 people know him/her but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: “Hi, A. Do you know B?” to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity’s label if there is a celebrity in the party. If there is no celebrity, return -1.
 *
 * https://medium.com/@joylovemercy/277-find-the-celebrity-linear-comparison-o-n-step-by-step-explanation-w-graph-8928230c6e
 */

public class FindTheCelebirity extends Relation {
    public int findCelebrity(int n) {
        // Compare and eliminate one that is not celebrity. Compare with the next number until reaching the last number.
        int candidate = 0;
        for (int j = 1; j < n; j++)
            if (knows(candidate, j)) {
                candidate = j; // We get a final candidate by linear comparison
            }

        // Check if the final candidate is the celebrity
        for (int k = 0; k < n; k++) {
            if (candidate == k) continue;
            if (knows(candidate, k) || !knows(k, candidate)) { // If it knows someone, or someone doesn't know it, it's not a celebrity
                return -1;
            }
        }
        return candidate;
    }

    @Override
    boolean knows(int a, int b) {
        // dummy implementation
        return false;
    }
}

abstract class Relation {
    abstract boolean knows(int a, int b);
}
