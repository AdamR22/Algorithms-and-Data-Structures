public class App {
    public static void main(String[] args) throws Exception {
        // HashTable Seperate Chaining
        HashTableSeperateChaining<String, String> mockDB = new HashTableSeperateChaining<>(5);
        mockDB.addEntry("Hey", "John Doe");
        mockDB.addEntry("Sith", "Jane Doe");
        mockDB.addEntry("Yoda", "Some other dude");
        mockDB.addEntry("Wants", "Some other dude");
        mockDB.addEntry("Milk", "Mnanitafuta na hamnipati");

        mockDB.addEntry("Hey", "Mock Value"); // Replaces value of entry of key value 1

        mockDB.printAllData();
        System.out.println();
        System.out.println("Sith Entry: " + mockDB.findEntry("Sith"));
        System.out.println();
        System.out.println("Has Yoda Key: " + mockDB.containsKey("Yoda"));
        System.out.println();
        System.out.println("Has John Doe Value: " + mockDB.containsValue("John Doe"));
        System.out.println();
        mockDB.remove("Milk");
        mockDB.printAllData();
        System.out.println();
        System.out.println("Hash Table Size: " + mockDB.getSize());
        System.out.println();
        System.out.println("Hash Table Capacity: " + mockDB.getCapacity());
        System.out.println();
        System.out.println(mockDB.isEmpty());
    }
}
