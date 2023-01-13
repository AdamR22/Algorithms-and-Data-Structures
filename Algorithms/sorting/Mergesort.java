class Mergesort {
    public static void mergeSort(int[] data) {

        if (data.length < 2) return;

        int n = data.length;

        int midpoint = n / 2;

        int[] leftArray = new int[midpoint];
        int[] rightArray = new int[n - midpoint];

        int k = 0;

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = data[k];
            k++;
        }

        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = data[k];
            k++;
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(leftArray, rightArray, data);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] data) {

        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                data[k] = leftArray[i];
                i++;
                k++;
            } else {
                data[k] = rightArray[j];
                j++;
                k++;
            }
        }

        while (i < leftArray.length) {
            data[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            data[k] = rightArray[j];
            j++;
            k++;
        }
    }    
}
