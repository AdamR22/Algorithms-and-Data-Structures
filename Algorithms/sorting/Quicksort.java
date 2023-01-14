public class Quicksort {
    public static void quickSort(int[] data, int startIndex, int endIndex) {
        if (endIndex <= startIndex)
            return;

        int pivotIndex = partitionAndSort(data, startIndex, endIndex);

        quickSort(data, startIndex, pivotIndex - 1);
        quickSort(data, pivotIndex + 1, endIndex);
    }

    private static int partitionAndSort(int[] data, int startIndex, int endIndex) {
        int pivotIndex = endIndex;
        int i = startIndex - 1;

        for (int j = 0; j < data.length; j++) {
            if (data[j] < data[pivotIndex]) {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        i++;
        int temp = data[i];
        data[i] = data[pivotIndex];
        data[pivotIndex] = temp;

        return i;
    }
}

