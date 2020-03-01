package array;

/**
 *
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i
 * is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the
 * most water.
 */

public class MostWaterContainer {

    public static int maxArea(int heights[]) {
        int maxArea =0;

        int pointer1 = 0;
        int pointer2 = heights.length-1;

        while(pointer1<pointer2) {
            int width = pointer2 - pointer1;
            if(heights[pointer1]<heights[pointer2]) {
                maxArea = Math.max(maxArea, width * heights[pointer1]);
                pointer1++;
            } else {
                maxArea = Math.max(maxArea, width * heights[pointer2]);
                pointer2--;
            }
        }
        return  maxArea;
    }

    public static void main(String arg[]) {
        int heightArr[] = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(heightArr));

    }
}
