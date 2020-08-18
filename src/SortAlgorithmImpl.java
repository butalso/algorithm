import java.util.*;

public class SortAlgorithmImpl implements SortAlgorithm {
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
                j--;
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
                    j = j - step;
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
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
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
        if (leftChild < len && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        if (rightChild < len && array[rightChild] > array[largest]) {
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
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        int[] count = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] tmp = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int idx = count[array[i] - min] - 1;
            tmp[idx] = array[i];
            count[array[i] - min]--;
        }

        for (int i = 0; i < tmp.length; i++) {
            array[i] = tmp[i];
        }
    }

    @Override
    public void bucketSort(int[] array) {
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        int step = 1000;
        int len = (max - min) / step + 1;
        List<Integer>[] buckets = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < array.length; i++) {
            int idx = indexFor(array[i], min, step);
            buckets[idx].add(array[i]);
        }

        int start = 0;
        for (int i = 0; i < buckets.length; i++) {
            int[] tmp = new int[buckets[i].size()];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = buckets[i].get(j);
            }
            insertionSort(tmp);
            for (int j = 0; j < tmp.length; j++) {
                array[start] = tmp[j];
                start++;
            }
        }
    }

    int indexFor(int val, int min, int step) {
        return (val - min) / step;
    }

    @Override
    public void radixSort(int[] array) {
        int k = maxBit(array);

        int radix = 1;
        for (int i = 0; i < k; i++) {
            int[] count = new int[10];
            for (int j = 0; j < array.length; j++) {
                int idx = (array[j] / radix) % 10;
                count[idx]++;
            }
            for (int j = 1; j < 10; j++) {
                count[j] += count[j - 1];
            }

            int[] tmp = new int[array.length];
            for (int j = array.length - 1; j >= 0; j--) {
                int idx = (array[j] / radix) % 10;
                tmp[count[idx] - 1] = array[j];
                count[idx]--;
            }

            for (int j = 0; j < array.length; j++) {
                array[j] = tmp[j];
            }
            radix *= 10;
        }
    }

    int maxBit(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int res = 1;
        while (max > 10) {
            res++;
            max = max / 10;
        }
        return res;
    }
}
