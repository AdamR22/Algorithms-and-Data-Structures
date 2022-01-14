public class App {
    public static void main(String[] args) throws Exception {
        DynamicArray array = new DynamicArray();
        array.add(1);
        array.add(4);
        array.add(5);
        array.add(7);
        array.remove(3);
        array.printAll();
        array.clear();
        int arraySize = array.getSize();
        System.out.println(arraySize);
    }
}
