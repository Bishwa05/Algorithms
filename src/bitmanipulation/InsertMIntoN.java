package bitmanipulation;

public class InsertMIntoN
{
    int updateBits(int n, int m, int i, int j) {
        /* create a mask to clear bits i through j in n
         * EXAMPLE: i = 2, j = 4. Result should be 11100011.
         * For simplicity, we'll just use 8 bits for the example.
         */
        int allOnes = ~0; //wil equal sequence of all 1s

        //1s before position j, then 0s. Left = 11100000
        int left = allOnes << (j + 1);

        //1s after position i. Right = 00000011
        int right = ((1 << i) - 1);

        //all 1s, except for 0s between i and j. Mask = 11100011
        int mask = left | right;

        /* clear bits j through i then put m in there */
        int n_cleared = n & mask; //clear bits j through i
        int m_shifted = m << i; //move m into correct position

        return n_cleared | m_shifted; //OR them, and we're done!
    }

    public static void main(String arg[]){
        InsertMIntoN i= new InsertMIntoN();
        System.out.println(i.updateBits(1082, 19, 2, 6));
    }
}
