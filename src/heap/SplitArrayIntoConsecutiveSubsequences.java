package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * Leetcode 659. Split Array into Consecutive Subsequences
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,3,4,5]
 * Output: true
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3
 * 3, 4, 5
 * Example 2:
 *
 * Input: nums = [1,2,3,3,4,4,5,5]
 * Output: true
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * Example 3:
 *
 * Input: nums = [1,2,3,4,4,5]
 * Output: false
 *
 *
 *
 */
public class SplitArrayIntoConsecutiveSubsequences
{
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> m = new HashMap<>();
        for(int n : nums){
            int prev = n-1;
            int len =0;

            if(m.containsKey(prev) && m.get(prev).size()>0){
                PriorityQueue<Integer> q = m.get(prev);
                len = q.poll();
            }
            len++;
            if(!m.containsKey(n)){
                m.put(n, new PriorityQueue<>());
            }
            PriorityQueue<Integer> q = m.get(n);
            q.offer(len);

        }
        for(PriorityQueue<Integer> q : m.values()){
            if(q.size() >0 && q.peek()<3) return false;
        }
        return true;

    }


    public boolean isPossible2(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums) {
            map.putIfAbsent(x, new PriorityQueue<>());
            int size = map.get(x).isEmpty() ? 0 : map.get(x).poll();
            map.putIfAbsent(x + 1, new PriorityQueue<>());
            map.get(x + 1).offer(++size);
        }
        return map.values().stream().noneMatch(q -> q.stream().anyMatch(x -> x < 3));
    }

    public static void main(String arg[]){
        SplitArrayIntoConsecutiveSubsequences n = new SplitArrayIntoConsecutiveSubsequences();
        int nums[] = {1,2,3,3,4,4,5,5};

        System.out.println(n.isPossible(nums));
    }
}
