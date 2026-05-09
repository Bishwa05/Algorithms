package k_way_merge;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumberInMSortedLists {
    class Node {
        int value, arrayIndex, elementIndex;
        Node (int v, int a, int e) {
            value = v;
            arrayIndex = a;
            elementIndex = e;
        }
    }
    public int findKthSmallest(List<List<Integer>> lists, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        // 1. Initial push: first element from each list
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null)
                minHeap.offer(new Node(lists.get(i).get(0), i, 0));
        }

        // 2. Extract min K times
        int count = 0, result = 0;
        while(!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            result = curr.value;
            if (++count == k) break;

            // 3. Push next element from the same list
            if(curr.elementIndex +1 < lists.get(curr.arrayIndex).size()) {
                minHeap.add(new Node(lists.get(curr.arrayIndex).get(curr.elementIndex +1),
                        curr.arrayIndex, curr.elementIndex+1));
            }
        }
    return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = List.of(List.of(2, 6, 8),
                List.of(3, 6, 7), List.of(1, 3, 4));

        List<List<Integer>> list2 = List.of(List.of(1, 2, 15),
                List.of(10, 12, 20), List.of(0, 100, 200));

        KthSmallestNumberInMSortedLists k = new KthSmallestNumberInMSortedLists();
        System.out.println(k.findKthSmallest(list2, 8));
    }
}
