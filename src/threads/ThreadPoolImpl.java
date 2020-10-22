package threads;

import java.util.LinkedList;
import java.util.Queue;



class ThreadPool {
    public Thread run(Runnable runnable){
        Thread t = new Thread(runnable);
        t.start();
        return t;
    }
}
public class ThreadPoolImpl
{
    private int maxSize = 0;
    ThreadPool threadPool;

    public ThreadPoolImpl(int size, ThreadPool threadPool){
        maxSize = size;
        this.threadPool = threadPool;
    }

    public void setMax(int size){
        System.out.print("Setting maxSize "+ size);


        if(maxSize == 0){
            maxSize = size;
            execute();
        } else{
            maxSize = size;
        }
    }


    class RunnableThreads implements Runnable{
        private Runnable r;
        RunnableThreads(Runnable r){
            this.r = r;
        }

        public void run(){
            r.run();
            currentSize--;
        }
    }

    private int currentSize = 0;
    private Queue<Runnable> waitingThreads = new LinkedList<>();
    private boolean isExecuting = false;
    private Object monitor = new Object();

    public void run(Runnable thread){
        synchronized(monitor){
            waitingThreads.offer(thread);
            execute();
        }
    }


    private void execute(){
        if(!isExecuting){
            isExecuting = true;
            ExecutingRunnable runnable = new ExecutingRunnable();
            threadPool.run(runnable);
        }
    }

    class ExecutingRunnable implements Runnable{

        public void run(){
            while(true){
                synchronized(monitor){
                    if(maxSize ==0){
                        isExecuting = false;
                        break;
                    }
                }

                while(waitingThreads.size()>0){
                    synchronized(monitor){
                        if(maxSize == 0){
                            isExecuting = false;
                            break;
                        }
                    }

                    if(currentSize<maxSize){
                        currentSize++;
                        Runnable run = waitingThreads.poll();
                        RunnableThreads r = new RunnableThreads(run);
                        threadPool.run(r);
                    }
                }

                synchronized(monitor){
                    if(waitingThreads.size()==0){
                        isExecuting = false;
                        break;
                    }
                }

            }
        }
    }

    public static void main(String args[]) throws InterruptedException{
        ThreadPool threadPool = new ThreadPool();
        ThreadPoolImpl impl = new ThreadPoolImpl(4, threadPool);
        int i;
        for(i=0; i < 10; i++){
            MyRunnable runnable = new MyRunnable(i);
            impl.run(runnable);
        }
        Thread.sleep(5000);
        impl.setMax(0);
        Thread.sleep(10000);
        impl.setMax(6);
        for(;i < 15;i++){
            MyRunnable runnable = new MyRunnable(i);
            impl.run(runnable);
        }
    }

}

class MyRunnable implements Runnable{
    int index = 0;
    MyRunnable(int index){
        this.index =index;
    }
    @Override
    public void run() {
        System.out.println("Start of index " + index);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Exception " + index + " " + e);
        }
        System.out.println("End of index " + index);
    }

}
