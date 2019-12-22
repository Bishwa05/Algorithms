package array;

import java.util.Scanner;

public class CountEvenNumbers {

    static boolean generateComb(long val) {
        String x = Long.toString(val);
        String y = "";

        long no =0;

        for(int i =0; i<x.length(); i++) {
            int j = x.length();

            if(i ==0){
                j =0;
            }

            while(j<=x.length() && i <x.length()) {
                y = x.substring(i, j);
                if(!y.isEmpty())
                    no += Long.parseLong(y);

                if(i==0){
                    j++;
                } else{
                    i++;
                }
            }
        }
        return (no%2==0);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        for(int i =0; i< n; i++) {

            long l = sc.nextLong();
            long u = sc.nextLong();
            int c =0;

            for(long j =l; j<=u; j++) {
                if(generateComb(j)) {
                    c++;
                }
            }
        System.out.println(c);
        }


    }
}
