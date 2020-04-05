package leetcodethirtydayschallenge;

/**
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class FindUnique {

    public static  int findUnique(int arr[]){
        int num =0;
        for(int x: arr){
            num = num ^ x;
        }
        return num;
    }

    public static void main(String arg[]) {
        int arr1[]= {2,2,1,1,3,4,3,5,4};
        System.out.println(findUnique(arr1));
    }
}
