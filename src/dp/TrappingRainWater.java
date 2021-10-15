package dp;

/**
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *  Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Algorithm
 *
 * Find maximum height of bar from the left end upto an index i in the array \text{left\_max}left_max.
 * Find maximum height of bar from the right end upto an index i in the array \text{right\_max}right_max.
 * Iterate over the \text{height}height array and update ans:
 *  Add min(left_max[i],right_max[i]) - height[i] to ans
 *
 */
public class TrappingRainWater
{
    public int trap(int[] height) {
        int totalWater = 0;
        int leftArr[] = new int[height.length];
        int rightArr[] = new int[height.length];

        if(height.length>0){
            leftArr[0] = height[0];
            rightArr[height.length -1] = height[height.length -1];

            for(int i =1; i< height.length; i++){
                leftArr[i] = Math.max(leftArr[i-1], height[i]);
            }

            for(int i = height.length -2; i>=0; i--){
                rightArr[i] = Math.max(rightArr[i+1], height[i]);
            }

            for(int i =0; i<height.length; i++){
                int minWall = Math.min(leftArr[i], rightArr[i]);
                totalWater = totalWater + minWall -height[i];
            }
        }
        return totalWater;
    }

    public static void main (String[] args)
    {
        TrappingRainWater t = new TrappingRainWater();
        int[] height = {4,2,0,3,2,5};
        System.out.println(t.trap(height));

        /** Dry run
         * leftArr = [4,4,4,4,4,5]
         * rightArr = [5,5,5,5,5,5]
         */

    }
}
