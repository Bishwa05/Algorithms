package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 * @param <T>
 */
public class StackWithTwoQueues<T> {

    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();

    public void push(T data){
        if(q1.isEmpty())
            q2.offer(data);
        else
            q1.offer(data);
    }

    public T pop() {
        int i=0, size;

        if(q2.isEmpty()){
            size = q1.size();
            while(i< size-1) {
                q2.offer(q1.poll());
                i++;
            }
            return q1.poll();
        } else {
            size = q2.size();
            while(i<size-1) {
                q1.offer(q2.poll());
                i++;
            }
        }
        return q2.poll();
    }

    public T top() {
        T x;
        if(q2.isEmpty()) {
            while(q1.size()>1){
                q2.offer(q1.poll());
            }
            x = q1.peek();
            q2.offer(q1.poll());
        } else {
            while(q2.size()>1){
                q1.offer(q2.poll());
            }
            x = q2.peek();
            q1.offer(q2.poll());
        }
        return x;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

}
