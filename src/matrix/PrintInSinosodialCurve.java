package matrix;

/**
 * Input [  1,  2,  3,  4,  5,
 *          6,  7,  8,  9,  10,
 *          11, 12  13, 14  15]
 *
 * Output [1,6,11,12,7,2,3,8,13,14,9,4,5,10,15]
 */
public class PrintInSinosodialCurve {

    public static void displaySinosodial(int [][]arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        int i =0;
        boolean down = true;

        for(int j = 0; j< cols;) {
            if(i==rows){
                down = false;
                j++; i--;
            }
            if(i==-1){
                down = true;
                j++;i++;
            }

            if(j== cols) break;

            while(down && i< rows){
                System.out.println(arr[i][j]);
                i++;
            }

            while(!down && i>= 0){
                System.out.println(arr[i][j]);
                i--;
            }
        }
    }


    public static void main(String arg[]) {
        int arr[][] ={{1,2,3,4,5},
                    {6,7,8,9,10},
                {11,12,13,14,15}};

        displaySinosodial(arr);
    }
}
