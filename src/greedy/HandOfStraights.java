package greedy;

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
        if (hand.length % W != 0) return false;

        TreeMap<Integer, Integer> cardCount = new TreeMap();
        // Count each card
        for (int card: hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        // Attempt to form group
        while (!cardCount.isEmpty()) {
            int first = cardCount.firstKey(); // Start with the smallest card
            for (int i = 0; i < W; i++) {
                int currentCard = first+i;
                if (!cardCount.containsKey(currentCard)) return false; // can not form the group
                int count = cardCount.get(currentCard);
                if (count == 1) cardCount.remove(currentCard);
                else cardCount.replace(currentCard, count - 1);
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
