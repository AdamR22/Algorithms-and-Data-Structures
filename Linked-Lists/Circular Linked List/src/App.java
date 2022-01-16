package src;

public class App {
    public static void main(String[] args) throws Exception {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.insertFirst(5);
        circularLinkedList.insertFirst(8);
        circularLinkedList.insertLast(1);
        circularLinkedList.insertItem(5, 9);
        circularLinkedList.deleteNode(5);
        // circularLinkedList.deleteHead();
        // circularLinkedList.deleteTail();
        circularLinkedList.traverse();
        System.out.println("Circular Linked List size " + circularLinkedList.getSize());
    }
}
