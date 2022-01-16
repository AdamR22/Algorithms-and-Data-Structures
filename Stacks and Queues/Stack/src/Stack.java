package src;

public class Stack<T> {
    // Class is generic, hence can be used for any data type
    private Node<T> head;
    private int size;

    public Stack() {
        this.head = null;
        this.size = 0;
    }

    private class Node<S> {
        private S data;
        private Node<S> next;

        private Node(S data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(T data) {
        Node<T> newNode = new Node<T>(data);

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        size++;
    }

    public T peek() {
        return this.head.data;
    }

    public void pop() {
        Node<T> temp = this.head;
        this.head = this.head.next;
        temp.next = null;

        size--;
    }

}
