package array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j= height.length-1;
        while(i<j){
            int min = Math.min(height[i], height[j]);
            max = Math.max(max, min*(j-i));
            if(height[j] > height[i])
                i++;
            else j--;

        }

        return max;
    }
}
