package Algorithm;

public class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    public static void sort(int[] arr, int start, int end) {
        if(start >= end - 1) return;

        int pivot = start + (end - start) / 2;

        int left = start,
            right = end - 1;
        
        while(left < pivot && right > pivot) {
            while(left < pivot && arr[left] <= arr[pivot]) {
                left++;
            }
            while(right > pivot && arr[right] > arr[pivot]) {
                right--;
            }

            if(left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp; 
            }
        }

        sort(arr, start, pivot);
        sort(arr, pivot, end);
    }
}
