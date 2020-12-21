package array;

public class MissingFirstPositive
{
    /**
     *
     * The idea is simple :
     *
     * 1. Check if there is no "1" then return "1"
     * 2. If there are all negative numbers in the array then return "1"
     * 3. If there is any negative number or the number is greater than the length of that array, then replace it by 1
     * 4. Now retraverse the array and do the following :
     * if arr[abs(arr[i])-1]>0 then replace arr[abs(arr[i])-1]=-1*arr[abs(arr[i])-1]
     * 5. Traverse the array again and if found first positive number then return index+1
     * 6. Otherwise, return arr.length+1
     *
     *
     *
     */
    public int firstMissingPositive2(int[] nums) {
        int one=0,neg=0,n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
                one++;
            if(nums[i]<0)
                neg++;
        }
        if(neg==n || one==0)
            return 1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<=0)
                nums[i]=1;
            else if(nums[i]>n)
                nums[i]=1;
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0 && nums[Math.abs(nums[i])-1]>0)
                nums[Math.abs(nums[i])-1]=-1*nums[Math.abs(nums[i])-1];

        }
        //System.out.println(Arrays.toString(nums));
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
                return i+1;
        }
        return n+1;
    }


    public int firstMissingPositive(int[] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] >= n)
                    break;

                if(A[i]==A[A[i]-1])
                    break;

                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++){
            if (A[i] != i + 1){
                return i + 1;
            }
        }

        return n + 1;
    }


    public static void main(String arg[]) {
        int arr[] ={3,4,-1,1};
        MissingFirstPositive m = new MissingFirstPositive();
        System.out.println(m.firstMissingPositive(arr));
    }
}
