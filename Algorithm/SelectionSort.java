package Algorithm;

public class SelectionSort {
    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int smallest = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }

            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i]= temp;
        }
    }

    public static void sort(int[] arr, int start, int end) {
        for(int i = start; i < end; i++) {
            int smallest = i;
            for(int j = i + 1; j < end; j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }

            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i]= temp;
        }
    }
}
