import java.util.Arrays;

public class TestSortAlgorithm {
    public static void main(String[] args) {
        SortAlgorithmImpl algorithm = new SortAlgorithmImpl();

        int[] array = new int[] {
                15124, 14334, 14354, 12341, 13211, 14223, 15111, 13210, 13998, 12899,
        };
        int[] expect = Arrays.copyOf(array, array.length);
        Arrays.sort(expect);

        int[] input = Arrays.copyOf(array, array.length);
        algorithm.bubbleSort(input);
        assert Arrays.equals(input, expect);

        input = Arrays.copyOf(array, array.length);
        algorithm.quickSort(input);
        assert Arrays.equals(input, expect);

        input = Arrays.copyOf(array, array.length);
        algorithm.insertionSort(input);
        assert Arrays.equals(input, expect);

        input = Arrays.copyOf(array, array.length);
        algorithm.shellSort(input);
        assert Arrays.equals(input, expect);

        input = Arrays.copyOf(array, array.length);
        algorithm.selectionSort(input);
        assert Arrays.equals(input, expect);

        input = Arrays.copyOf(array, array.length);
        algorithm.heapSort(input);
        assert Arrays.equals(input, expect);

        input = Arrays.copyOf(array, array.length);
        algorithm.mergeSort(input);
        // System.out.println("input:  " + Arrays.toString(input));
        // System.out.println("expect: " + Arrays.toString(expect));
        assert Arrays.equals(input, expect);

        input = Arrays.copyOf(array, array.length);
        algorithm.countSort(input);
        assert Arrays.equals(input, expect);

        input = Arrays.copyOf(array, array.length);
        algorithm.bucketSort(input);
        assert Arrays.equals(input, expect);

        input = Arrays.copyOf(array, array.length);
        algorithm.radixSort(input);
        assert Arrays.equals(input, expect);
    }
}
