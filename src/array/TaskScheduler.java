package array;

/**
 * 621. Task Scheduler
 */
public class TaskScheduler {
    public int leastInterval(char[] t,int n) {
        if(n>= t.length) return t.length;

        if(t.length%n ==0) return t.length+ t.length/n-1;
        else return t.length + t.length/n;
    }



    public static void main(String arg[]) {
        char chars[] = {'A','A','A','B','B','B','C'};
        int n = 10;
        TaskScheduler t  = new TaskScheduler();
        System.out.println(t.leastInterval(chars, n));

    }


}
