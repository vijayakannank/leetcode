package array;

/**
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
 *
 * If it cannot be done, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 */
public class MinimumDominoRotationsForEqualRow {

    int minDominoRotations(int[] tops, int[] bottoms) {

        int[][] c = new int[6][2];

        for (int i : tops) {
            c[i - 1][0]++;
        }
        for (int i : bottoms) {
            c[i - 1][1]++;
        }
        int[] common = new int[6];
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == bottoms[i]) {
                common[tops[i] - 1]++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            if (c[i - 1][0] + c[i - 1][1] >= tops.length) {
                if (c[i - 1][0] >= c[i - 1][1] && c[i - 1][1] - common[i - 1] + c[i - 1][0] == tops.length) {
                    min = Math.min(min, c[i - 1][1] - common[i - 1]);
                }
                else if (c[i - 1][1] >= c[i - 1][0] && c[i - 1][0] - common[i - 1] + c[i - 1][1] == tops.length) {
                    min = Math.min(min, c[i - 1][0] - common[i - 1]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
