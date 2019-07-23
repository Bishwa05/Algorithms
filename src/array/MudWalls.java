package array;

/**
 * Problem Statement
 * A child likes to build mud walls by placing mud between sticks positioned on a number line.
 * The gap between sticks will be referred to as a cell, and each cell will contain one segment of wall.
 * The height of mud in a segment cannot exceed 1 unit above an adjacent stick or mud segment.
 * Given the placement of a number of sticks and their heights, determine the maximum height segment of mud that can be built. If no mud segment can be built, return 0.
 *
 * For example, there are n = 3 sticks at stickPositions = [1, 2, 4, 8]
 * with stickHeights = [4, 5, 7, 11].
 * There is no space between the first two sticks, so there is no cell for mud.
 * Between positions 2 and 4, there is one cell. Heights of the surrounding sticks are
 * 5 and 7, so the maximum height of mud is 5 + 1 = 6.
 * Between positions 4 and 7 there are two cells. The heights of surrounding sticks
 * are 7 and 11. The maximum height mud segment next to the stick of height 7 is 8.
 * The maximum height mud next to a mud segment of height 8 and a stick of height 11 is 9.
 * Mud segment heights are 6, 8 and 9, and the maximum height is 9. In the table below,
 * digits are in the columns of sticks and M is in the mud segments.
 *
 *       7
 *       7
 *      M7
 *     MM7
 *    4MM7
 *   M4MM7
 *  2M4MM7
 * 12M4MM7
 * 12M4MM7
 * 12M4MM7
 * 12M4MM7
 *

 * Function Description
 * Complete the function maxHeight in the editor below. The function must return an integer,
 * the maximum height mud segment that can be built.
 *
 * maxHeight has the following parameter(s):
 * stickPositions[stickPositions[0],…stickPositions[n-1]]: an array of integers
 * stickHeights[stickHeights[0],…stickHeights[n-1]]: an array of integers
 *
 * Constraints
 * 1 ≤ n ≤ 105
 * 1 ≤ stickPositions[i] ≤ 109 (where 0 ≤ i < n)
 * 1 ≤ stickHeights[i] ≤ 109 (where 0 ≤ i < n)
 *
 * Sample Input For Custom Testing
 *
 * 3
 * 1
 * 3
 * 7
 * 3
 * 4
 * 3
 * 3
 *
 *
 * Sample Output
 *
 * 5

 * Explanation
 *
 *     M
 * 1M MMM
 * 1M3MMM7
 * 1M3MMM7
 * 1M3MMM7
 *
 *     M
 * 1M MMM
 * 1M3MMM7
 * 1M3MMM7
 * 1M3MMM7 - 4434543   4434432
 *
 * Here stickPositions = [1, 3, 7] and stickHeights = [4, 3, 3]. There can be a segment of height 4 at position 2 supported by sticks of heights 4 and 3. Between positions 3 and 7, there can be a segment of height 4 at positions 4 and 6. Between them, a segment can be built of height 5 at position 5.
 */

public class MudWalls {

    public static int getMaxWallHeight(int pos [], int height[]){

        int h = 0;
        int max =0;

        for(int i=0; i< pos.length-1; i++){
            //gap found (2nd pos)
            if(pos[i]< pos[i+1]-1) {
                //height diff (4-3 =1)
                int heightDiff = (height[i + 1] > height[i]) ? height[i + 1] - height[i] : height[i] - height[i + 1];
                int posDiff = pos[i + 1] - pos[i];

                int localMax = 0;
                if (posDiff > heightDiff) {
                    int low = Math.max(height[i + 1], height[i]) + 1;
                    int remainingGap = posDiff - heightDiff - 1;
                    localMax = low + remainingGap / 2;
                } else {
                    localMax = Math.min(height[i + 1], height[i]) + posDiff;
                }

                max = Math.max(max, localMax);
            }
        }


        return max;
    }
    public static void main(String arg[]) {

        int position[] ={1,3,7};
        int height[] = {4,3,3};

        System.out.println(getMaxWallHeight(position,height));

        int position1[] = {1, 2, 4, 8};
        int height1[] = {4, 5, 7, 11};

        System.out.println(getMaxWallHeight(position1,height1));
    }
}
