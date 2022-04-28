public class App {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(5);

        pQueue.addItem(3);
        pQueue.addItem(20);
        pQueue.addItem(1);
        pQueue.addItem(5);
        pQueue.addItem(15);

        pQueue.iterator();

        System.out.println(pQueue.getSize());

        pQueue.remove(5);

        pQueue.iterator();

        System.out.println(pQueue.getSize());
    }
}
