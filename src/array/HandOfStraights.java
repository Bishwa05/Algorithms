package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HandOfStraights
{
    Map<Integer, Integer> freq = new HashMap<>();
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if(n%W !=0) return false;

        Arrays.sort(hand);

        for(int card: hand){
            freq.put(card, freq.getOrDefault(card, 0)+1);
        }

        for(int i=0; i<n; i++){
            if(freq.get(hand[i])>0){
                if(!dfs(hand[i], W)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int card, int w){
        if(w ==0) return true;

        if(!freq.containsKey(card) || freq.get(card)==0) return false;

        int cur = freq.get(card);
        cur--;
        freq.put(card, cur);
        return dfs(card+1, w-1);
    }


    public boolean isNStraightHand2(int[] hand, int W) {
        TreeMap<Integer, Integer> count = new TreeMap();
        for (int card: hand) {
            if (!count.containsKey(card))
                count.put(card, 1);
            else
                count.replace(card, count.get(card) + 1);
        }

        while (count.size() > 0) {
            int first = count.firstKey();
            for (int card = first; card < first + W; ++card) {
                if (!count.containsKey(card)) return false;
                int c = count.get(card);
                if (c == 1) count.remove(card);
                else count.replace(card, c - 1);
            }
        }

        return true;
    }

    public static void main(String args[]){
        int nums[] = {1,2,3,6,2,3,4,7,8};

        HandOfStraights h = new HandOfStraights();
        System.out.println(h.isNStraightHand(nums, 3));

    }
}
