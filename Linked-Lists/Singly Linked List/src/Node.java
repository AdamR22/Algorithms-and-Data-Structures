class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public int getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }
}