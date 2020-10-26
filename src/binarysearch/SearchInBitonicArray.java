package binarysearch;

/**
 * Bitonic Array = [1, 3, 6, 8, 9, 5, 4, 2]
 * Search 4
 *
 *  Approach
 *  1. Find the high.
 *  2. search from both sides till high
 */
public class SearchInBitonicArray
{

    private int binarySerach(int[] arr, int target, int hi, boolean leftToRight){

        if(leftToRight){
          int lo=0;
          while(lo<=hi){
              int mid = (lo+hi)>>>1;
              if(arr[mid] == target){
                  return mid;
              } else if(arr[mid]<target){
                  lo = mid+1;
              } else{
                  hi = mid-1;
              }
          }

        } else{
            int lo = arr.length-1;
            while(lo>=hi){
                int mid = (lo+hi)>>>1;
                if(arr[mid] == target){
                    return mid;
                } else if(arr[mid]<target){
                    lo = mid-1;
                } else{
                    hi = mid+1;
                }
            }
        }

        return -1;
    }

    public int serachIndex(int []arr, int target){
        // find max element index
        int maxIndex = FindPeakElement.findPeakElement(arr);
        int res =-1;
        if(maxIndex!=0) {
            res = binarySerach(arr, target, maxIndex, true);
            if(res!= -1) return res;
        }
        if(maxIndex!=arr.length-1)
            res = binarySerach(arr, target, maxIndex, false);

        return res;
    }

    public static void main(String arg[]){
        SearchInBitonicArray s = new SearchInBitonicArray();
        int[] x = {1, 3, 6, 8, 9, 5, 4, 2};
        System.out.println(s.serachIndex(x,8));
    }

}
