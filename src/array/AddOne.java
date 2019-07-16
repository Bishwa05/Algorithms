package array;

import java.util.ArrayList;
import java.util.List;

public class AddOne {

    public static long getSum(int arr[]){
        List<Integer> arrList = new ArrayList<>();
        int one =1;
        int carry =0;
        for(int i=arr.length-1; i>=0; i--){
             int sum =0;
            int unit = arr[i];
            if(i == arr.length-1){
                sum = arr[i]+carry+one;

            } else{
                sum = arr[i]+carry;

            }
            if(sum ==10){
                unit = 0;
                carry =1;
            }else{
                unit = sum;
                carry =0;
            }
            arrList.add(unit);
        }
        if(carry ==1){
            arrList.add(carry);
        }

        String s ="";
        for(int i= arrList.size()-1; i>=0; i--){
            s= s+arrList.get(i);
        }
        return new Long(s);

    }

    public static void main(String arg[]) {
        int arr[] ={ 0, 3, 7, 6, 4, 0, 5, 5, 5};
        System.out.println(getSum(arr));
    }
}
