package binarysearch;

/**
 *
 * Leetcode
 * 1011. Capacity To Ship Packages Within D Days
 *
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 *
 *
 * Divide the array in D equal parts or close to D equal parts
 *
 * Time complexity O((high - low)* n) for brute force
 * O(log((high - low)* n)) for binary serach
 */
public class CapacityToShipPackagesWithinDDays
{
    public int shipWithinDays(int[] weights, int D){

        if(weights == null || weights.length ==0){
            return 0;
        }

        int low =0;
        int high = 0;

        for(int w : weights){
            low = Math.max(low, w);
            high +=w;
        }

        //Brute force

//        for(int w = low; w<= high; ++w){
//            if(getMinWeights(weights, w)<=D){
//                return w;
//            }
//        }

        while(low<high){
            int mid = (low+high)>>1;
            if(getMinWeights(weights, mid)<=D){
                high = mid;
            } else{
                low = mid+1;
            }
        }
        return low;

    }

    public int getMinWeights(int[] weights, int maxWight){
        int minWeight = 0;
        int currWeight = 0;

        for(int w : weights){
            if(currWeight+ w > maxWight){
                minWeight +=1;
                currWeight = w;
            } else{
                currWeight += w;
            }
        }
        return minWeight+1;
    }

    public static void main(String arg[]){
        int []nums ={1,2,3,4,5,6,7,8,9,10};
        CapacityToShipPackagesWithinDDays c = new CapacityToShipPackagesWithinDDays();
        System.out.println(c.shipWithinDays(nums, 5));
    }
}
