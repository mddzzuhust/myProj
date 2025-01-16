package heap;
//在Java中，可以使用PriorityQueue类来实现小顶堆。PriorityQueue默认就是一个小顶堆。
import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        // 创建一个小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 插入元素
        minHeap.offer(10);
        minHeap.offer(5);
        minHeap.offer(15);

        // 查看堆顶元素，即最小值
        System.out.println("最小值: " + minHeap.peek());

        // 移除并返回堆顶元素
        System.out.println("移除的最小值: " + minHeap.poll());

        // 再次查看堆顶元素
        System.out.println("最小值: " + minHeap.peek());
    }
}
