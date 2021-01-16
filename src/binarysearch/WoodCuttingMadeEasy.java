package binarysearch;

import java.util.ArrayList;

/**
 *
 *  A = [20, 15, 10, 17]
 *  B = 7
 *
 *   15
 *    If you the height parameter to 15 then you can chop:
 *   5 metres from first tree
 *   0 metres from second tree
 *   0 metres from third tree
 *   2 metres from fourth tree
 *   So in total you chopped 7 metres of wood.
 *
 *
 *    A = [4, 42, 40, 26, 46]
 *    B = 20
 *
 *   36
 *
 *   If you the height parameter to 36 then you can chop:
 *   0 metres from first tree
 *   6 metres from second tree
 *   4 metres from third tree
 *   0 metres from fourth tree
 *   10 metres from fifth tree
 *   So in total you chopped 20 metres of wood.
 */
public class WoodCuttingMadeEasy
{
    public int solve(ArrayList<Integer> A, int B) {
        int h = 0;
        int max =0;
        int min = 0;
        int ans = 0;

        for(int i =0; i< A.size(); i++){
            max = Math.max(max, A.get(i));
        }

        while(min<=max){
            int mid = min + (max-min)/2;
            long wood =0;
            for(int j =0; j<A.size(); j++){
                if(A.get(j)-mid>0){
                    wood = wood+A.get(j)-mid;
                }
            }
            if(wood>=(long)B){
                min = mid+1;
                ans = Math.max(ans, mid);
            } else {
                max = mid-1;
            }
        }
        return ans;
    }
}
