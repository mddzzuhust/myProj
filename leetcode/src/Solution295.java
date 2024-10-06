import java.util.PriorityQueue;

public class Solution295 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(5);
        medianFinder.findMedian();
        medianFinder.addNum(8);
        medianFinder.addNum(89);
        medianFinder.addNum(789);
        medianFinder.findMedian();
    }

    static class MedianFinder {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<Integer>((x,y)->(y-x));
            minHeap = new PriorityQueue<Integer>();
        }

        public void addNum(int num) {
            if(maxHeap.size() != minHeap.size()){
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size() != minHeap.size()){
                return minHeap.peek();
            }else {
                return (maxHeap.peek() + minHeap.peek())/2.0;
            }
        }
    }
}
