package list;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

    static Deque<Integer> deque;
    static HashSet<Integer> hashSet;

    static int size;

    LRUCache(int n){
        deque = new LinkedList<>();
        hashSet = new HashSet<>();
        this.size = n;
    }


    // By default the less accessed element will be present at the end in the queue
    public void put(int x) {
        if(!hashSet.contains(x)){
            if(deque.size() == this.size){
                int last = deque.removeLast();
                hashSet.remove(last);
            }
        } else {
            //element added is already present, that needs to be moved to front

            Iterator<Integer> itr = deque.iterator();
            while(itr.hasNext()) {
                if(x == itr.next()){
                    break;
                }
            }
            deque.remove(x);

        }
        deque.push(x);
        hashSet.add(x);
    }

    public void display() {
        Iterator<Integer> it = deque.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println("");
    }

    public static void main(String arg[]) {
        LRUCache c = new LRUCache(4);

        c.put(2);
        c.put(3);
        c.put(4);
        c.put(5);
        c.display();
        c.put(6);
        c.put(4);
        c.display();


    }
}
