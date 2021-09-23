package dfs;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Leetcode 473. Matchsticks to Square
 *
 * Example 1:
 * Input: [1,1,2,2,2]
 * Output: true
 *
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * Example 2:
 * Input: [3,3,3,3,4]
 * Output: false
 *
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 */
public class MatchsticksToSquare
{
    public List<Integer> nums;
    public int[] sums;
    public int possibleSquareSide;

    public MatchsticksToSquare() {
        this.sums = new int[4];
    }

    /**
     * Time complexity O(4^n)
     */
    public boolean dfs(int index){
        if(index == this.nums.size()){
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        // current matchstick
        int element = this.nums.get(index);

        for(int i =0; i<4; i++) {
            if(this.sums[i] + element <= this.possibleSquareSide){
                this.sums[i] += element;
                if(this.dfs(index+1)){
                    return true;
                }
                this.sums[i] -= element;
            }
        }
        return false;

    }

    public boolean makeSquare(int[] nums){
        if(nums == null || nums.length ==0){
            return false;
        }

        int L = nums.length;
        int perimeter = 0;

        for(int i =0; i<L; i++){
            perimeter += nums[i];
        }
            this.possibleSquareSide = perimeter/4;

        if(this.possibleSquareSide * 4 != perimeter){
            return false;
        }

        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, Collections.reverseOrder());
        //return this.dfs(0);

        // DP
        this.nums2 = nums;
        this.memo = new HashMap<Pair<Integer, Integer>, Boolean>();
        return this.recurse((1 << L) - 1, 0);

    }

    /**
     *
     *
     * DP approach
     */
    public HashMap<Pair<Integer, Integer>, Boolean> memo;
    public int[] nums2;
//
//    public int possibleSquareSide;

    //this.memo = new HashMap<Pair<Integer, Integer>, Boolean>();

    public boolean recurse(Integer mask, Integer sidesDone){
        int total = 0;
        int L = this.nums2.length;

        Pair<Integer, Integer> memoKey = new Pair(mask, sidesDone);

        for(int i = L-1; i>=0; i--){
            if((mask &(1<<i))==0){
                total += this.nums2[L-1-i];
            }
        }


        // If the sum if divisible by our square's side, then we increment our number of complete sides formed variable.
        if (total > 0 && total % this.possibleSquareSide == 0) {
            sidesDone++;
        }

        // Base case.
        if (sidesDone == 3) {
            return true;
        }

        // Return precomputed results
        if (this.memo.containsKey(memoKey)) {
            return this.memo.get(memoKey);
        }


        boolean ans = false;
        int c = total / this.possibleSquareSide;

        // Remaining vlength in the current partially formed side.
        int rem = this.possibleSquareSide * (c + 1) - total;

        // Try out all remaining options (that are valid)
        for(int i = L - 1; i >= 0; i--) {
            if (this.nums2[L - 1 - i] <= rem && (mask&(1 << i)) > 0) {
                if (this.recurse(mask ^ (1 << i), sidesDone)) {
                    ans = true;
                    break;
                }
            }
        }

        // Cache the computed results.
        this.memo.put(memoKey, ans);
        return ans;

    }
}
