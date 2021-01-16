package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProcessFile implements Runnable{
    int threadNo;

    ProcessFile(int threadNo, int[] arr){
        this.threadNo = threadNo;
        this.arr = arr;
    }

    private int[] arr;



    @Override
    public void run() {
        System.out.println("Starting "+threadNo);
        for (int i = 0; i < 10; i++) {
            String idx = threadNo +""+i;
            int id = Integer.parseInt(idx);
            System.out.println("Executing "+threadNo+" with "+Thread.currentThread().getName()+"===="+arr[id]);
        }
        System.out.println("Ending "+threadNo);
    }
}

public class ProcessParalel
{
    public static int[] prepareArray(){

        int[] arr = new int[100];
        for(int i =0;i<arr.length; i++){
            arr[i] =i;
        }
        return arr;
    }

    public static void main(String arg[]){
        int arr[] = prepareArray();
        ExecutorService es= Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            ProcessFile loopTask=new ProcessFile(i, arr);
            es.submit(loopTask);
        }
        es.shutdown();
    }
}
