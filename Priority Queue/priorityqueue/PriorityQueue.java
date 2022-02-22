package priorityqueue;


/**
 * PriorityQueue
 */
public class PriorityQueue {
    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(12);
        heap.add(2);
        heap.add(7);
        heap.printItems();
    }
}