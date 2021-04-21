package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Leetcode
 * 1296. Divide Array in Sets of K Consecutive Numbers
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4
 * Output: true
 * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
 * Example 2:
 *
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * Output: true
 * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
 * Example 3:
 *
 * Input: nums = [3,3,2,2,1,1], k = 3
 * Output: true
 * Example 4:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * Explanation: Each array should be divided in subarrays of size 3.
 *
 *
 */
public class DivideArrayInSetOfKConsecutiveNumber
{

    public boolean isPossibleDivide(int[] nums, int k){
        if(nums.length%k !=0){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Arrays.sort(nums);

        for(int i =0; i<nums.length; i++){
            if(map.get(nums[i])==0){
                continue;
            }
            if(!check(nums, map, nums[i], k)){
                return false;
            }
        }
        return true;
    }

    public boolean check(int nums[], Map<Integer, Integer>map, int number, int k){
        for(int i = number; i<number+k; i++){
            if(!map.containsKey(i)){
                return false;
            } else {
                if(map.get(i)<=0) return false;
                else{
                    map.put(i, map.get(i)-1);
                }
            }
        }
        return true;
    }

    public static void main(String arg[]){
        int[] nums = {1,2,3,3,4,4,5,6};

        DivideArrayInSetOfKConsecutiveNumber d = new DivideArrayInSetOfKConsecutiveNumber();
        System.out.println(d.isPossibleDivide(nums, 4));
    }
}
