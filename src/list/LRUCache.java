package list;

import java.util.*;

public class LRUCache {
    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int n){
        this.capacity = n;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertAtHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = val;
            remove(node);
            insertAtHead(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, val);
            map.put(key, newNode);
            insertAtHead(newNode);
        }

    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // By default the less accessed element will be present at the end in the queue


    public void display() {

    }

    public static void main(String arg[]) {
        LRUCache c = new LRUCache(4);

//        c.put(2);
//        c.put(3);
//        c.put(4);
//        c.put(5);
//        c.display();
//        c.put(6);
//        c.put(4);
//        c.display();


    }
}
