public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private class Node {
        private int data;
        private Node next;
        private Node prev;

        private Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public void insertFirst(int data) {

        // Adds node to head of linked list
        Node newNode = new Node(data);

        if (this.head == null) {
            // List is empty hence new node is both head and tail
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }

        size++;
    }

    public void insertLast(int data) {
        // Adds node to tail of linked list
        Node newNode = new Node(data);
        if (this.tail == null) {
            // List is empty hence new node is both head and tail;
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
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
        newNode.prev = currentNode;
        currentNode.next = newNode;

    }

    public void traverse() {
        Node currentNode = this.head;
        int nodeNumber = 0;

        while (currentNode != null) {
            System.out.println(String.format("Node number: %s, data: %s", nodeNumber, currentNode.data));
            currentNode = currentNode.next;
            nodeNumber++;
        }
    }

    public Node deleteHead() {
        Node temp = this.head;

        this.head = temp.next;
        this.head.prev = null;

        return temp;
    }

    public Node deleteTail() {
        Node temp = this.tail;

        this.tail = temp.prev;
        temp.prev = null;
        this.tail.next = null;

        return temp;
    }

    public Node deleteNode(int data) {
        Node currentNode = this.tail;

        while (currentNode.data != data) {
            currentNode = currentNode.next;
        }

        currentNode.prev.next = currentNode.next;
        currentNode.next = null;
        currentNode.prev = null;

        return currentNode;
    }
}
