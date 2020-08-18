import java.util.*;

public class SortAlgorithmImpl implements SortAlgorithm {
    // 比较排序
    // 交换排序
    /*
     * 稳定性排序
     * 时间复杂度：最好O(n)，最坏O(n^2)，平均O(n^2)
     * 空间复杂度：O(1)，原地排序
     */
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /*
     * 非稳定性排序
     * 时间复杂度：最好O(nlogn)，最坏O(n^2)，平均O(nlogn)
     * 空间复杂度：O(1)，原地排序
     */
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int d = quickSortPartition(array, start, end);
        quickSort(array, start, d - 1);
        quickSort(array, d + 1, end);
    }

    int quickSortPartition(int[] array, int start, int end) {
        int pivot = array[start];
        int preIndex = start + 1;
        for (int i = preIndex; i <= end; i++) {
            if (array[i] <= pivot) {
                swap(array, preIndex, i);
                preIndex++;
            }
        }
        swap(array, start, preIndex - 1);
        return preIndex - 1;
    }

    // 插入排序
    /*
     * 稳定性排序
     * 时间复杂度：最好O(n)，最坏O(n^2)，平均O(n^2)
     * 空间复杂度：O(1)，原地排序
     */
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > tmp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = tmp;
        }
    }

    /*
     * 非稳定性排序
     * 时间复杂度：最好O(n)，最坏O(n^2)，平均O(nlogn^2)
     * 空间复杂度：O(1)，原地排序
     */
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

    // 选择排序
    /*
     * 非稳定性排序
     * 时间复杂度：最好O(n^2)，最坏O(n^2)，平均O(n^2)
     * 空间复杂度：O(1)，原地排序
     */
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

    /*
     * 非稳定性排序
     * 时间复杂度：最好O(nlogn)，最坏O(nlogn)，平均O(nlogn)
     * 空间复杂度：O(1)，原地排序
     */
    int heapLen;
    public void heapSort(int[] array) {
        heapLen = array.length;
        buildMaxHeap(array);

        while (heapLen > 0) {
            swap(array, 0, heapLen - 1);
            heapLen--;
            heapify(array, 0);
        }
    }

    void buildMaxHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i);
        }
    }

    void heapify(int[] array, int i) {
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int largest = i;
        if (leftChild < heapLen && array[leftChild] > array[largest]){
            largest = leftChild;
        }
        if (rightChild < heapLen && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, largest);
        }
    }

    // 归并排序
    /*
     * 稳定性排序
     * 时间复杂度：最好O(nlogn)，最坏O(nlogn)，平均O(nlogn)
     * 空间复杂度：O(n)，外地排序
     */
    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
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
            start++;
            i++;
        }
        while (j < right.length) {
            array[start] = right[j];
            start++;
            j++;
        }
    }

    // 非比较排序
    /*
     * 稳定性排序，设k为数的跨度范围，适用于k不是很大，数比较集中
     * 时间复杂度：O(n+k)
     * 空间复杂度：O(n+k)
     */
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

        int[] ans = new int[array.length];
        for (int j = array.length - 1; j >= 0; j--) {
            int idx = count[array[j] - min] - 1;
            ans[idx] = array[j];
            count[array[j] - min]--;
        }

        for (int i = 0; i < ans.length; i++) {
            array[i] = ans[i];
        }
    }

    /*
     * 稳定性排序，计数排序升级版
     */
    final int bucketStep = 10;
    int indexFor(int j, int min) {
        return (j - min) / bucketStep;
    }
    public void bucketSort(int[] array) {
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }
        int length  = (max - min) / 10 + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < array.length; i++) {
            int idx = indexFor(array[i], min);
            buckets.get(idx).add(array[i]);
        }

        int index = 0;
        for (int i = 0; i < length; i++) {
            int[] tmpArray = new int[buckets.get(i).size()];
            for (int j = 0; j < tmpArray.length; j++) {
                tmpArray[j] = buckets.get(i).get(j);
            }
            insertionSort(tmpArray);
            for (int j = 0; j < tmpArray.length; j++) {
                array[index] = tmpArray[j];
                index++;
            }
        }
    }

    /*
     * 稳定性排序，从低位到高位排序
     */
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
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int d = 1;
        while (max > 10) {
            max = max / 10;
            d++;
        }
        return d;
    }

    void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}