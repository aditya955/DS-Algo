package Algorithm;

public class MergeSort {
    /*
     * To sort whole array from start to end (modifies original array)
     * arr -> Array to sort
     */
    public static void sort(int[] arr) {
        System.arraycopy(divide(arr, 0, arr.length),
                0, arr,
                0, arr.length);
    }

    /*
     * To sort using Merge Sort algorithm within given range
     * arr -> Array to sort
     * start -> starting index of array to sort (inclusive)
     * end -> ending index of array to sort (exclusive)
     */
    public static void sort(int[] arr, int start, int end) {
        System.arraycopy(divide(arr, start, end),
                0, arr,
                start, (end - start));
    }

    /*
     * Returns sorted array without modifying the original array
     * arr -> Array to sort from
     */
    public static int[] toSorted(int[] arr) {
        return divide(arr, 0, arr.length);
    }

    /*
     * Returns sorted array within range
     * arr -> Array to sort from
     * start -> Start index from where to sort (includsive)
     * end -> End index till where to sort (exclusive)
     */
    public static int[] toSorted(int[] arr, int start, int end) {
        return divide(arr, start, end);
    }

    private static int[] divide(int[] arr, int start, int end) {
        if (start == end - 1) {
            return new int[] { arr[start] };
        }

        int mid = start + (end - start) / 2;
        int[] left = divide(arr, start, mid);
        int[] right = divide(arr, mid, end);

        int[] sorted = new int[left.length + right.length];

        merge(sorted, left, right);

        return sorted;
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int l = 0,
                r = 0,
                index = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                arr[index++] = left[l++];
            } else {
                arr[index++] = right[r++];
            }

        }

        while (l < left.length) {
            arr[index++] = left[l++];
        }

        while (r < right.length) {
            arr[index++] = right[r++];
        }
    }
}
