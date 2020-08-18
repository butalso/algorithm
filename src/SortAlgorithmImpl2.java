import java.util.Arrays;

public class SortAlgorithmImpl2 implements SortAlgorithm {
    void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    @Override
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    @Override
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = quickSortPartition(array, start, end);
        quickSort(array, start, mid - 1);
        quickSort(array, mid + 1, end);
    }

    int quickSortPartition(int[] array, int start, int end) {
        int pivot = array[start];
        int preIndex = start + 1;
        for (int i = preIndex; i <= end; i++) {
            if (array[i] < pivot) {
                swap(array, i, preIndex);
                preIndex++;
            }
        }
        swap(array, start, preIndex - 1);
        return preIndex - 1;
    }

    @Override
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
            }
            array[j + 1] = tmp;
        }
    }

    @Override
    public void shellSort(int[] array) {
        for (int step = array.length / 2; step > 0; step = step / 2) {
            for (int i = step; i < array.length; i++) {
                int tmp = array[i];
                int j = i - step;
                while (j >= 0 && array[j] > tmp) {
                    array[j + step] = array[j];
                }
                array[j + step] = tmp;
            }
        }
    }

    @Override
    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }

    @Override
    public void heapSort(int[] array) {
        buildMaxHeap(array);
        for (int len = array.length - 1; len >= 0; len--) {
            swap(array, 0, len);
            heapify(array, 0, len);
        }
    }

    void buildMaxHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }
    }

    void heapify(int[] array, int i, int len) {
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int largest = i;
        if (leftChild < len && array[leftChild] < array[largest]) {
            largest = leftChild;
        }
        if (rightChild < len && array[rightChild] < array[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            swap(array, largest, i);
            heapify(array, largest, len);
        }
    }

    @Override
    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    void mergeSort(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        int[] left = Arrays.copyOfRange(array, start, mid + 1);
        int[] right = Arrays.copyOfRange(array, mid + 1, end + 1);

        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[start] = left[i];
                i++;
            } else {
                array[start] = right[j];
                j++;
            }
            start++;
        }

        while (i < left.length) {
            array[start] = left[i];
            i++;
            start++;
        }
        while (j < right.length) {
            array[start] = right[j];
            j++;
            start++;
        }
    }

    @Override
    public void countSort(int[] array) {

    }

    @Override
    public void bucketSort(int[] array) {

    }

    @Override
    public void radixSort(int[] array) {

    }
}
