package Algorithm;

/*
 * DNF -> Dutch National Flag Algorithm
 * This algorithm is used to sort arrays consisting of 0, 1 & 2
 * Time Complexity: O(n)
 * 
 * We have 3 pointers, low, medium and high
 * Between 0 to low - 1 -> All 0's are present
 * Between low to medium - 1 -> All 1's are present
 * Between medium to high - 1 -> Unsorted Array
 * Between high till end -> All 2's are present
 * 
 * From this, we have to sort the unsorted part (between medium to high)
 * We do this by iterating from medium till high by doing following operations:
 *  if current element is 0
 *      swap it with low, and increment low & mid pointer
 *  if current element is 1
 *      increment mid pointer
 *  if current element is 2
 *      swap it with high pointer and decrement high pointer
 */

public class DNF {
    public static void sort(int[] arr) {
        int low = 0,
            mid = 0,
            high = arr.length - 1;

        while(mid <= high) {
            if(arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
