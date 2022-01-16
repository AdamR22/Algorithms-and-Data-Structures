package src;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.head.next = this.head;
        } else {
            newNode.next = this.head;
            this.head.next = newNode;
            this.head = newNode;
        }

        size++;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
            this.head.next = this.head;
        } else {
            this.tail.next = newNode;
            newNode.next = this.head;
            this.tail = newNode;
        }

        size++;
    }

    public void insertItem(int dataInWantedNodeLocation, int newData) {
        /*
        Since I have no indices, dataInWantedNodeLocation helps us
        find the location where we want to insert data to. 
        */
        Node newNode = new Node(newData);
        Node currentNode = this.head;

        while (currentNode.data != dataInWantedNodeLocation) {
            currentNode = currentNode.next;
        }

        newNode.next = currentNode.next;
        currentNode.next = newNode;

    }

    public void traverse() {
        Node currentNode = this.head;
        int nodeNumber = 0;

        while (currentNode.next != this.head) {
            System.out.println(String.format("Node number: %s, data: %s", nodeNumber, currentNode.data));
            currentNode = currentNode.next;
            nodeNumber++;
        }

        //Prints out data in last node to prevent circular motion
        System.out.println(String.format("Node number: %s, data: %s", nodeNumber, currentNode.data));
    }

    public Node deleteHead() {
        Node temp = this.head;

        this.head = this.head.next;
        this.tail.next = this.head; // Make tail next pointer point to new head

        return temp;
    }

    public Node deleteTail() {
        Node currentNode = this.head;
        Node temp = null;

        while (currentNode.next != this.tail) {
            currentNode = currentNode.next;
        }

        temp = currentNode.next;
        currentNode.next = this.head;
        this.tail = currentNode;

        return temp;
    }

    public Node deleteNode(int data) {
        Node currentNode = this.head;

        while (currentNode.next.data != data) {
            currentNode = currentNode.next;
        }

        Node temp = currentNode.next;

        currentNode.next = currentNode.next.next;

        return temp;
    }
}
