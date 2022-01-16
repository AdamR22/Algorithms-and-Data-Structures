package src;

public class Queue<D> {
    private class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<D> head;
    private Node<D> tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public D front() {
        return this.head.data;
    }

    public void dequeue() {
        Node<D> temp = this.head;
        this.head = this.head.next;
        temp.next = null;

        size--;
    }

    public void enqueue(D data) {
        Node<D> newNode = new Node<>(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        size++;
    }
}
