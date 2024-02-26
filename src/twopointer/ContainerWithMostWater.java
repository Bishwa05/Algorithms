package twopointer;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int pointer1 = 0;
        int pointer2 = height.length -1;

        int maxArea = 0;

        while(pointer1 < pointer2) {
            int width = pointer2-pointer1;
            if(height[pointer1]>height[pointer2]) {
                maxArea = Math.max(maxArea, height[pointer2]*width);
                pointer2--;
            } else {
                maxArea = Math.max(maxArea, height[pointer1]*width);
                pointer1++;
            }
        }
        return maxArea;
    }
}
