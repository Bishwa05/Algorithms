package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LEETCODE
 * 464. Can I Win
 *https://leetcode.com/problems/can-i-win/
 *
 * Share
 * In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player who first causes the running total to reach or exceed 100 wins.
 * What if we change the game so that players cannot re-use integers?
 *
 */
public class CanIWin
{
    public Map<Integer , Boolean> dp;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal){
        dp = new HashMap<>();
        if(maxChoosableInteger <1 || desiredTotal<0) throw new IllegalArgumentException();

        if(desiredTotal ==0) return true;

        if(maxChoosableInteger * (maxChoosableInteger+1)/2 < desiredTotal) return false;

        //dfs
        return !dfs(desiredTotal , new boolean[maxChoosableInteger + 1] , maxChoosableInteger , 0);
    }

    private boolean dfs(int sum , boolean[] visited , int maxChoosableInteger , int mask){
        if(sum <= 0) return true;
        boolean flag = false;
        if(dp.containsKey(mask)) return dp.get(mask);

        for(int i = 1 ; i <= maxChoosableInteger ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                flag = flag || dfs(sum - i , visited , maxChoosableInteger , (1 << i) | mask);
                visited[i] = false;
            }
        }

        dp.put(mask , !flag);
        return !flag;
    }


    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal<=0) return true;
        if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
        return canIWin(desiredTotal, new int[maxChoosableInteger], new HashMap<>());
    }

    private boolean canIWin(int total, int[] state, HashMap<String, Boolean> hashMap) {
        String curr= Arrays.toString(state);
        if (hashMap.containsKey(curr)) return hashMap.get(curr);
        for (int i=0;i<state.length;i++) {
            if (state[i]==0) {
                state[i]=1;
                if (total<=i+1 || !canIWin(total-(i+1), state, hashMap)) {
                    hashMap.put(curr, true);
                    state[i]=0;
                    return true;
                }
                state[i]=0;
            }
        }
        hashMap.put(curr, false);
        return false;
    }


    public static void main(String arg[]){
        CanIWin c = new CanIWin();
        System.out.println(c.canIWin(10, 11));
    }
}
