package Algorithm;

public class MergeSort
{
    // @SuppressWarnings("unchecked")
    public void sort(int[] arr) {
        System.arraycopy(sort(arr, 0, arr.length), 
                        0, arr, 
                        0, arr.length);
    }
    
    private int[] sort(int[] arr, int start, int end) {
        if(start == end - 1) {
            return new int[]{arr[start]};
        }

        int mid = start + (end - start) / 2;
        int[] left = sort(arr, start, mid);
        int[] right = sort(arr, mid, end);

        int[] sorted = new int[left.length + right.length];
        
        merge(sorted, left, right);

        return sorted;
    }

    private void merge(int[] arr, int[] left, int[] right) {
        int l = 0, 
            r = 0,
            index = 0;

        while(l < left.length && r < right.length) {            
            if(left[l] < right[r]) {
                arr[index++] = left[l++];
            } else {
                arr[index++] = right[r++];
            }

        }

        while(l < left.length) {
            arr[index++] = left[l++];
        }

        while(r < right.length) {
            arr[index++] = right[r++];
        }
    }
}
