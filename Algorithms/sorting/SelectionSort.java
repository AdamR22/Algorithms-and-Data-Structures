public class SelectionSort{

    public static void main(String[] args) throws Exception {
        int[] array = { 4, 9, 1, 5 };

        System.out.println("Insertion Sort: ");
        
        insertionSort(array);
    }

    static void selectionSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minimumIndex = i; 
            int currentMinIndex = i;
        
            
            for (int j = i; j < data.length; j++) {

                if (data[currentMinIndex] > data[j]) currentMinIndex = j;
            }

            if (data[currentMinIndex] < data[minimumIndex]) {
                int temp = data[minimumIndex];
                data[minimumIndex] = data[currentMinIndex];
                data[currentMinIndex] = temp;   
            }
        }

        for (int i : data) {
            System.out.print(i + ", ");
        }
    }
}
