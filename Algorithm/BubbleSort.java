package Algorithm;

public class BubbleSort {
    public static void sort(int[] arr) {
        boolean updated;
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            updated = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    updated = true;
                }
                if(!updated) return;
            }
        }
    }

    public static void sort(int[] arr, int start, int end) {
        if(start < 0 || end > arr.length) throw new ArrayIndexOutOfBoundsException();
        if(end == arr.length) {
            sort(arr);
            return;
        }

        boolean updated;
        int n = end;
        for(int i = start; i < n - 1; i++) {
            updated = false;
            for(int j = start; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    updated = true;
                }
                if(!updated) return;
            }
        }
    }
}
