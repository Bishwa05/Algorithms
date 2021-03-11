package unionfind;

import java.util.*;

/**
 *
 * Leetcode 128. Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 */
class UnionSet{
    int[] representative;
    int[] sizes;
    int[] ranks;

    UnionSet(int n){
        representative = new int[n];
        sizes = new int[n];
        ranks = new int[n];
        for(int i =0; i<n; i++){
            representative[i] = i;
        }
        Arrays.fill(sizes, 1);
    }

    public int find(int i){
        if(i != representative[i]){
            representative[i] = find(representative[i]);
        }
        return  representative[i];
    }

    public int combine(int a, int b){
        int id1 = find(a);
        int id2 = find(b);

        if(id1 == id2)
            return -1;


        if(ranks[id1]> ranks[id2]){
            representative[id2] = id1;
            sizes[id1] += sizes[id2];
            return sizes[id1];
        } else {
            representative[id1] = id2;
            sizes[id2] += sizes[id1];
            if(ranks[id1]==ranks[id2]){
                ranks[id2]++;
            }
            return sizes[id2];
        }

    }
}
public class LongestConsecutiveSequence
{

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n <=1)
            return n;

        int longestConsLen = 1;
        Map<Integer, Integer> mp = new HashMap<>();
        UnionSet union = new UnionSet(n);

        for(int i =0; i<n; i++){
            int j = nums[i];
            if(mp.containsKey(j)){
                continue;
            }
            mp.put(j, i);

            if(mp.containsKey(j-1)){
                longestConsLen = Math.max(longestConsLen, union.combine(i, mp.get(j-1)));
            }

            if(mp.containsKey(j+1)){
                longestConsLen = Math.max(longestConsLen, union.combine(i, mp.get(j+1)));
            }
        }
        return longestConsLen;

    }


    /***********************************************************/
    /**
     * O(n)
     */
    public int longestConscutive(int[] nums){
        Set<Integer> numset = new HashSet<>();
        for(int num : nums){
            numset.add(num);
        }
        int longStreak =0;

        for(int num:numset){
            if(!numset.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while(numset.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak +=1;
                }
                longStreak = Math.max(longStreak, currentStreak);
            }
        }
        return longStreak;
    }

}
