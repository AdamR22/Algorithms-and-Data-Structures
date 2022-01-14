public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void traverse() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public void insertAtHead(int data) {
        Node node = new Node(data);

        // If head is null, tail is null since list is empty
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }

        this.size++;
    }

    public void insertAtTail(int data) {
        Node node = new Node(data);

        // If tail is null, head is null since list is empty
        if (this.tail == null) {
            this.tail = node;
            this.head = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }

        this.size++;
    }

    public Node removeHead() {
        Node temp = this.head;
        this.head = temp.getNext();
        temp.setNext(null);

        this.size--;
        return temp;
    }

    public Node removeTail() {
        Node temp = this.tail;
        Node currentNode = this.head;

        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(null);
        this.tail = currentNode;
        temp.setNext(null);

        this.size--;
        return temp;
    }
}
