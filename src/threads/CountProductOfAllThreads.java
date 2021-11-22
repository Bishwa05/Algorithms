package threads;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Q. Suppose there are n number of threads to take n inputs.
 * Then spawn the last thread to count the product of numbers
 * which has been taken as input by n previous threads.
 */
public class CountProductOfAllThreads
{
    int arr[];
    int prod = 1;
    class Process implements Runnable{
        boolean isCompute;
        int thNo;
        Process(boolean isCompute, int thNo){
            this.isCompute = isCompute;
            this.thNo = thNo;
        }
        public void run(){
            if(isCompute){
                for(int i =0; i< arr.length; i++){
                    prod *= arr[i];
                    System.out.println("Prod"+ thNo+":"+prod);
                }
            } else {
                //Scanner sc = new Scanner(System.in);
                arr[thNo] = (thNo+1)*2;
                System.out.println("HI"+ arr[thNo]);
                //sc.close();
            }

        }

    }

    public  void readNumber(int n) {
        try {
            ExecutorService ex = Executors.newFixedThreadPool(n + 1);
            arr = new int[n];
            CountDownLatch countDownLatch = new CountDownLatch(2);
            for (int i = 0; i < n; i++) {
                ex.submit(new Process(false, i));
                countDownLatch.countDown();
            }
            // Thread.sleep(1000);
            countDownLatch.await();
            ex.submit(new Process(true, n));

            ex.shutdown();
        } catch (Exception e){
            //throw new Exception(e);
        }
    }

    public static void main (String[] args)
    {
        CountProductOfAllThreads cp = new CountProductOfAllThreads();
        Scanner sc = new Scanner(System.in);
        cp.readNumber(sc.nextInt());
        System.out.println(cp.prod);
        sc.close();
    }
}
