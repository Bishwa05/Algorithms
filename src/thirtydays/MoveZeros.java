package thirtydays;

/**
 * Given an array nums, write a function to move all 0's
 * to the end of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeros {

    public static void moveZeros(int nums[]) {
        int p1 = 0;
        int p2 = 0;

        if(nums.length >1) {
            while(p2<nums.length-1) {
                if(nums[p2] !=0){
                    p2++;
                    if(p1<nums.length-1) p1++;
                }

                if(nums[p2] ==0){
                    while(nums[p1]==0 && p1<nums.length-1) p1++;

                    int x = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2] =x;
                    p2++;
                }
            }
        }

        for(int i=0; i<nums.length; i++)
            System.out.println(nums[i]);

    }

    public static void main(String args[]){
        int arr[] = {0,1,0,3,12};
        //int arr[] = {1,0};
        moveZeros(arr);
    }
}
