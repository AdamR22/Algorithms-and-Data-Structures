public class DynamicArray {
    private Integer[] array;
    private int size; // Number of items in array
    private int capacity; // Number of items array will hold

    public DynamicArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Capacity cannot be less than zero");
        this.capacity = capacity;
        array = (Integer[]) new Integer[capacity]; // Create new array with desired capacity
    }

    public DynamicArray() {
        // Creates array of 16 items if class is instantiated with no capacity
        this(16);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, int item) {
        if (index < 0 || index >= size)
            // Prevents setting value to position that doesn't exist
            throw new IllegalArgumentException("Invalid index");
        array[index] = item;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public void add(int element) {
        if (size >= capacity) {
            if (capacity == 0)
                capacity = 1; // If array empty, allocate one slot
            else
                capacity *= 2; // double array capacity;
            Integer[] newArray = (Integer[]) new Integer[capacity]; // New array with double capacity
            for (int i = 0; i <= capacity; i++) {
                newArray[i] = array[i]; // Copy items of old array to new array
            }

            array = newArray; // Old array assigned to new array;
        }

        array[size] = element;
        size++;
    }

    public int remove(int itemIndex) {
        if (itemIndex > size || itemIndex < 0)
            throw new IllegalArgumentException();
        int dataRemoved = array[itemIndex];
        Integer[] newArray = (Integer[]) new Integer[capacity - 1];

        for (int i = 0, j = 0; i < size; i++, j++)
            if (i == itemIndex)
                j--; // Skip over itemIndex by fixing j temporarily
            else
                newArray[j] = array[i];
        array = newArray;
        capacity = --size;
        return dataRemoved;
    }

    public void printAll() {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                System.out.println(array[i]);
            }
        }

    }
}
