package array;

/**
 * https://leetcode.com/problems/trapping-rain-water
 *
 * Given n non-negative integers representing an elevation map where
 * the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Soln:
 * Compute the highest from left.
 * Compute the highest from right
 * Then find the min wall height which can capture water.
 * After min wall height - actual height at that point is the unit of water.
 *
 *
 */
public class TrappingRainWater {

    public static int max(int low, int high, int [] array) {
        int max = array[low];
        for(int i=low+1; i<high; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }

    public static int trap(int[] height) {
        int totalWater =0;
        int leftArr[] = new int[height.length];
        int rightArr[] = new int[height.length];
        if(height.length>0) {
            leftArr[0] = height[0];
            rightArr[height.length - 1] = height[height.length - 1];

            for (int i = 1; i < height.length; i++) {
                leftArr[i] = Math.max(leftArr[i - 1], height[i]);
            }

            for (int i = height.length - 2; i >= 0; i--) {
                rightArr[i] = Math.max(rightArr[i + 1], height[i]);
            }

            for (int i = 0; i < height.length; i++) {
                int minWall = Math.min(leftArr[i], rightArr[i]);

                totalWater = totalWater + minWall - height[i];
            }
        }

        return totalWater;

    }

    public static void main(String arg[]) {
        int height[] ={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
