package dp;

import java.util.List;

/**
 *
 * There is a one-dimensional garden of length N. In each position of the N length garden,
 * a fountain has been installed. Given an array a[]such that a[i] describes the coverage limit of ith fountain.
 * A fountain can cover the range from the position max(i – a[i], 1) to min(i + a[i], N).
 * In beginning, all the fountains are switched off. The task is to find the minimum number of fountains needed to be activated such that the whole N-length garden can be covered by water.
 *
 *
 * traverse the array and for every array index, i.e. ith fountain, find the leftmost fountain up to which the current fountain covers.
 * Then, find the rightmost fountain that the leftmost fountain obtained in the above step covers up to and update it in the dp[] array.
 * Initialize a variable cntFount to store the minimum number of fountains that need to be activated.
 * Now, traverse the dp[] array and keep activating the fountains from the left that covers maximum fountains currently on the right and increment cntFount by 1. Finally, print cntFount as the required answer.
 *
 */

public class CountMinFountain
{
    public int minCountFountain(List<Integer> locations){

        int n = locations.size();
        int[] dp = new int[n];

        for(int i =0; i<n; i++){
            int left = Math.max(i - locations.get(i), 0);
            int right = Math.min(i+locations.get(i)+1, n);
            dp[left] = Math.max(dp[left], right);
        }
        int count = 1;
        int idNext = 0;
        int idRight = dp[0];

        for(int i =0; i<n; i++){
            idNext = Math.max(idNext,dp[i]);
            if(i== idRight){
                count++;
                idRight = idNext;
            }
        }
        return count;

    }
}
