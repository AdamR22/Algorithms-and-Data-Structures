public class App {
    public static void main(String[] args) throws Exception {
        LinkedList singlyLinkedList = new LinkedList();

        singlyLinkedList.insertAtHead(1);
        singlyLinkedList.insertAtHead(9);
        singlyLinkedList.insertAtTail(1);
        singlyLinkedList.insertAtHead(44);
        singlyLinkedList.insertAtHead(99);
        singlyLinkedList.insertAtTail(12);
        singlyLinkedList.traverse();
        singlyLinkedList.removeTail();
        singlyLinkedList.removeHead();
        singlyLinkedList.traverse();
        int size = singlyLinkedList.getSize();
        System.out.println(String.format("Linked List size: %s", size));
    }
}
