public class BubbleSort{

    public static void main(String[] args) throws Exception {
        int[] array = { 4, 9, 1, 5 };

        bubbleSort(array);
    }

    static void bubbleSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                int temp = data[j];

                if (data[j] > data[j + 1]) {
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        for (int i : data) {
            System.out.print(i + ", ");
        }
    }
}
