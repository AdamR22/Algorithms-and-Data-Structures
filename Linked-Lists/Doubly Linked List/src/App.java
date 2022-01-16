public class App {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList linkedList = new DoublyLinkedList();

        linkedList.insertLast(2);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertItem(6, 5);
        linkedList.traverse();

        //Other methods have been tested, you can try them out on your own should you choose
    }
}
