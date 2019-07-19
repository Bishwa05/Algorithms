package array;


/**
 * Find a sub array with given sum
 * 12
 * 1 2 3 7 5
 *
 * Since we need to find in a sub array form the given array so here we should not sort it.
 */
public class SubArraySum {

    public static void findSubArraySum(int a[], int sum) {
        int len = a.length;
        int currSum = 0, start =0;
        for(int i=0; i<= len; i++) {

            while (currSum > sum && start < i-1)
            {
                currSum = currSum - a[start];
                start++;
            }
            if (currSum == sum)
            {
                int p = i-1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);

            }
            // Add this element to curr_sum
            if (i < len)
                currSum = currSum + a[i];

        }
    }

    public static void main(String arg[]) {
        int [] arr = {1, 2, 3, 7, 5};
        int sum =12;
        findSubArraySum(arr,sum);
    }

}
