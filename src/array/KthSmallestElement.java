package array;

public class KthSmallestElement
{

    public int findKthSmallest(int []nums, int k){
        //k = nums.length -k;
        int lo = 0;
        int hi = nums.length-1;

        while(lo<hi){
            int mid = partition(nums, lo, hi);

            if(mid ==k){
                break;
            } else if(mid <k){
                lo = mid+1;
            } else {
                hi = mid -1;
            }
        }
        return nums[k];
    }

    public int partition(int[] nums, int lo, int hi){
        int p = nums[lo];
        int i = lo;
        int j = hi;

        while(true){
            while(i<hi && nums[i]<=p) i++;
            while(j>lo && nums[j]>p) j--;

            if(i>=j) break;

            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    public void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String arg[]) {
        int arr[] = {3,2,5,1, -6, 7};
        int k =3;
        // System.out.println(findKthLargest(arr, k));

        KthSmallestElement s = new KthSmallestElement();
        System.out.println(s.findKthSmallest(arr, k));
    }
}
