public interface SortAlgorithm {
    /*
     * 稳定性排序
     * 时间复杂度：最坏O(n^2)，平均O(n^2)，最好O(n)
     * 空间复杂度：O(1)
     */
    void bubbleSort(int[] array);

    /*
     * 非稳定性排序
     * 时间复杂度：最坏O(n^2)，平均O(nlogn)，最好O(nlogn)
     * 空间复杂度：O(logn)
     */
    void quickSort(int[] array);

    /*
     * 稳定性排序
     * 时间复杂度：最坏O(n^2)，平均O(n^2)，最好O(n)
     * 空间复杂度：O(1)
     */
    void insertionSort(int[] array);

    /*
     * 非稳定性排序
     * 时间复杂度：和步长有关系，平均O(n^1.3)
     * 空间复杂度：O(1)
     */
    void shellSort(int[] array);

    /*
     * 非稳定行排序
     * 时间复杂度：最坏O(n^2)，平均O(n^2)，最好O(n^2)
     * 空间复杂度：O(1)
     */
    void selectionSort(int[] array);

    /*
     * 非稳定性排序
     * 时间复杂度：最好O(nlogn)，平均O(nlogn)，最好O(nlogn)
     * 空间复杂度：O(1)
     */
    void heapSort(int[] array);

    /*
     * 稳定性排序
     * 时间复杂度：最好O(nlogn)，平均O(nlogn)，最好O(nlogn)
     * 空间复杂度：O(n)
     */
    void mergeSort(int[] array);

    /*
     * 稳定性排序，适用于数比较集中的排序，设跨度为k
     * 时间复杂度：O(n+k)
     * 空间复杂度：O(k)
     */
    void countSort(int[] array);

    /*
     * 计数排序升级版
     */
    void bucketSort(int[] array);

    /*
     * 
     */
    void radixSort(int[] array);
}
