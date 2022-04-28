import java.util.*;

class PriorityQueue<T extends Comparable<T>> {
    private int heapSize;
    private List<T> heap;

    PriorityQueue(int size) {
        heap = new ArrayList<T>(size);
        heapSize = heap.size();
    }

    PriorityQueue() {
        this(1);
    }

    PriorityQueue(Collection<T> container) {
        //Initializes new pQueue with elements from a collection
        this(container.size());
        for (T item : container) heap.add(item);
    }

    public void iterator() {
        /*
        Prints all items occupying priorityQueue
       */
        for (T t : heap) {
            System.out.println(t);
        }
    }

    public boolean isEmpty() {
        //Returns true if pQueue is empty and false otherwise
        return this.heap.isEmpty();
    }

    public T peek() {
        //Returns first item in pQueue
        return this.heap.get(0);
    }

    public T poll() {
        //Returns item removed from pQueue
        return this.heap.remove(0);
    }

    public int getSize() {
        //Returns size of pQueue
        return this.heap.size();
    }

    public boolean lessThan(int i, int j) {
        T nodeOne = this.heap.get(i);
        T nodeTwo = this.heap.get(j);

        return nodeOne.compareTo(nodeTwo) < 0;
    }

    public void addItem(T item) {
        this.heap.add(item);
        swim(item);
    }

    public void swap(int i, int j) {
        T nodeOne = this.heap.get(i);
        T nodeTwo = this.heap.get(j);

        this.heap.set(i, nodeTwo);
        this.heap.set(j, nodeOne);
    }

    public void swim(T item) {
        int elementPosition = this.heap.indexOf(item);

        int parent = (elementPosition - 1) / 2;

        while (elementPosition > 0 && lessThan(elementPosition, parent)) {
            swap(parent, elementPosition);
            elementPosition = this.heap.indexOf(item);
            parent = (elementPosition - 1) / 2;
        }
    }

    public void sink(int elemPos) {
        //Elempos tracks position of node we are sinking
        while (true) {
            int leftNodeIndex = 2 * elemPos + 1;
            int rightNodeIndex = 2 * elemPos + 2;

            int smallest = leftNodeIndex; //smallest is index of least priority node

            if (smallest < heapSize && lessThan(rightNodeIndex, leftNodeIndex)) smallest = rightNodeIndex;

            if (smallest >= heapSize || lessThan(elemPos, smallest)) break;

            swap(smallest, elemPos);

            elemPos = smallest; //updates value of elempos
        }
    }

    public void remove(T elem) {
        if (this.isEmpty()) throw new IllegalArgumentException();
        int lastElementPosition = this.heap.size() - 1;
        int elementPosition = this.heap.indexOf(elem); // Position of element to be removed

        if (elementPosition == lastElementPosition) {
            this.heap.remove(lastElementPosition);
        }

        swap(elementPosition, lastElementPosition);

        this.heap.remove(lastElementPosition);

        sink(elementPosition);

        if (this.heap.get(elementPosition).equals(elem)) swim(elem);
    }
}
