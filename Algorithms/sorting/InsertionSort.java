public class InsertionSort{

    public static void main(String[] args) throws Exception {
        int[] array = { 4, 9, 1, 5 };

        System.out.println("Insertion Sort: ");
        
        insertionSort(array);
    }

    static void insertionSort(int[] data) {
        for (int i = 1; i < data.length; i ++) {
            int j = i;
            int key = data[j];

            while (j > 0 && data[j - 1] > key) {
                data[j] = data[j - 1];
                j--;
            }

            data[j] = key;
        }

        for (int i : data) {
            System.out.print(i + ", ");
        }
    }
}
