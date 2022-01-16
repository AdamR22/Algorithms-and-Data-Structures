package src;

public class App {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.front());
        queue.dequeue();
        System.out.println(queue.front());
    }
}
