package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 * Leetcode : 1642. Furthest Building You Can Reach
 */
public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<heights.length-1; i++) {
            if (heights[i]>= heights[i+1]) continue;
            bricks -= heights[i+1] - heights[i];
            pq.add(heights[i+1] - heights[i]);

            if (bricks <0) {
                bricks += pq.poll();

                if(ladders >0) ladders--;
                else return i;
            }
        }
        return heights.length -1;
    }

    public static void main(String[] args) {
        FurthestBuildingYouCanReach f = new FurthestBuildingYouCanReach();
        int [] arr = new int []{4,12,2,7,3,18,20,3,19};
        int bricks = 10;
        int ladder = 2;
        System.out.println(f.furthestBuilding(arr, bricks, ladder));
    }
}
