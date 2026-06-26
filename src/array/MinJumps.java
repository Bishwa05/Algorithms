package array;

public class MinJumps {
    static int minJumps(int arr[], int l, int h)
    {
        // Base case: when source
        // and destination are same
        if (h == l)
            return 0;

        // When nothing is reachable
        // from the given source
        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        // Traverse through all the points
        // reachable from arr[l]. Recursively
        // get the minimum number of jumps
        // needed to reach arr[h] from these
        // reachable points.
        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
            int jumps = minJumps(arr, i, h);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }
        return min;
    }

    public static int jumpOptimal(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0;
        int currentJumpEnd = 0;
        int farthestReachable = 0;

        // Loop through the array (no need to process the last element)
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the absolute furthest index we could possibly step onto
            farthestReachable = Math.max(farthestReachable, i + nums[i]);

            // If we reached the boundary of our current jump window
            if (i == currentJumpEnd) {
                jumps++;                       // We are forced to make a jump
                currentJumpEnd = farthestReachable; // Update our window to the new furthest point

                // Optimization: If our new window can already hit the end, we can stop early
                if (currentJumpEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        int n = arr.length;
        System.out.println("Minimum number of jumps to reach end is "
                + minJumps(arr, 0, n - 1));

        System.out.println("Minimum number of jumps to reach end is "
                + jumpOptimal(arr));
    }
}
