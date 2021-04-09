package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
}
