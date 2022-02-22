package priorityqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * BinaryHeap
 */
public class BinaryHeap<T extends Comparable<T>> {
    private List<T> heap = null;

    public BinaryHeap(int heapSize) {
        heap = new ArrayList<T>(heapSize);
    }

    public BinaryHeap() {
        // Secondary consttructor that initializes heap with size of 1
        this(1);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public void clear() {
        heap.clear();
    }

    public T peek() {
        if (isEmpty())
            return null;
        return heap.get(0);
    }

    public T poll() {
        return removeAt(0);
    }

    public boolean contains(T item) {
        for (int i = 0; i < size(); i++) {
            if (heap.get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void add(T elem) {

        if (elem == null)
            throw new IllegalArgumentException();

        heap.add(elem);

        int indexOfLastElem = size() - 1;
        swim(indexOfLastElem);
    }

    private void sink(int k) {
        int heapSize = size();
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;

            if (right < heapSize && less(right, left))
                smallest = right;

            if (left >= heapSize || less(k, smallest))
                break;

            swap(smallest, k);
            k = smallest;
        }
    }

    public void swap(int i, int j) {
        T itemOne = heap.get(i);
        T itemTwo = heap.get(j);

        heap.set(i, itemTwo);
        heap.set(j, itemOne);
    }

    public boolean remove(T item) {
        if (item == null)
            return false;

        for (int i = 0; i < size(); i++) {
            if (item.equals(heap.get(i))) {
                removeAt(i);
                return true;
            }
        }

        return false;
    }

    private T removeAt(int i) {
        if (isEmpty())
            return null;

        int indexOfLastItem = size() - 1;
        T itemToRemove = heap.get(i);
        swap(i, indexOfLastItem);

        heap.remove(indexOfLastItem);

        if (i == indexOfLastItem)
            return itemToRemove;

        T item = heap.get(i);

        sink(i);

        if (heap.get(i).equals(item))
            swim(i);

        return itemToRemove;
    }

    public boolean isMinHeap(int k) {
        int heapSize = size();
        if (k >= heapSize)
            return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        if (left < heapSize && !less(k, left))
            return false;
        if (right < heapSize && !less(k, right))
            return false;

        return isMinHeap(left) && isMinHeap(right);
    }

    public void printItems() {
        for (T t : heap) {
            System.out.println(t);
        }
    }

    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    private void swim(int k) {
        int parent = (k - 1) / 2;

        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            k = parent;

            parent = (k - 1) / 2;
        }
    }
}