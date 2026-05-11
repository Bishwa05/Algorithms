package twoheap;

import java.util.PriorityQueue;

public class FindMedianOfDataStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    FindMedianOfDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b -a);
        minHeap = new PriorityQueue<>((a, b) -> a -b);
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeap.size() > minHeap.size() +1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxHeap.peek();
    }


    // Another way with less code

    public void addNum(int num) {
        maxHeap.offer(num); // add to maxHeap
        minHeap.offer(maxHeap.poll()); // balance step

        if(maxHeap.size() < minHeap.size()) { // maintain size
            maxHeap.offer(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        FindMedianOfDataStream medianOfAStream = new FindMedianOfDataStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}

