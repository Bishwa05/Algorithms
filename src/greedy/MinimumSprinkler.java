package greedy;

import org.omg.Messaging.SyncScopeHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Given an array arr[] consisting of N integers, where the ith element represents the range of a sprinkler i.e [i-arr[i], i+arr[i]] it can water, the task is to find the minimum number of the sprinkler to be turned on to water every plant at the gallery. If it is not possible to water every plant, then print -1.
 * Note: If arr[i] = -1, then the sprinkler cannot be turned on.
 *
 *
 * Input: arr[ ] = {-1, 2, 2, -1, 0, 0}
 * Output: 2
 * Explanation:
 * One of the possible way is:
 *
 *     Turn on the sprinkler at index 2, it can water the plants in the range [0, 4].
 *     Turn on the sprinkler at index 5, it can water the plants in the range [5, 5].
 *
 * Therefore, turning two sprinklers on can water all the plants. Also, it is the minimum possible count of sprinklers to be turned on.
 *
 * Input: arr[ ] = {2, 3, 4, -1, 2, 0, 0, -1, 0}
 * Output: -1
 *
 */
public class MinimumSprinkler {

    class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public int minSprinklers(int arr[], int N){
        // store the left and right most point of each sprinkler.
        List<Pair> pairList = new ArrayList<>();
        for(int i=0; i<N; i++){
            if(arr[i]>-1){
                pairList.add(new Pair(i-arr[i], i+arr[i]));
            }
        }

        Collections.sort(pairList, (a, b)-> a.x-b.x);

        int maxRight = 0;
        int res = 0;
        int i =0;

        while(maxRight < N){

            if(i==pairList.size() || pairList.get(i).x>maxRight){
                return -1;
            }
            int currMax = pairList.get(i).y;

            //iterate until i+1< pairList.size() && pairList[i+1].x<=maxRight
            while(i+1<pairList.size() && pairList.get(i+1).x<=maxRight){
                i++;
                currMax = Math.max(currMax, pairList.get(i).y);
            }
            if(currMax<maxRight){
                return -1;
            }

            res++;
            maxRight = currMax+1;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumSprinkler m = new MinimumSprinkler();
        int arr[] = {-1, 2, 2, -1, 0, 0};

        System.out.println(m.minSprinklers(arr, arr.length));
    }
}
