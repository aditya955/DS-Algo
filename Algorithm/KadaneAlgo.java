package Algorithm;

/*
 * Kadane's Algorithm - Used to find max subarray sum
 * The algorithm is used to find the maximum sum from an subarray
 * We start by initializing the sum = 0 and max to minimum possible value 
 * Then iterate the array:
 *  Add the current value to sum variable
 *  Check whether sum > max, if it is, then reassign max = sum
 *  if at any point sum < 0, then reinitialize the sum to 0
 * 
 * To find the start and end index of the subarray, we can store the index in start and end variables to point towards correct index.
 */

public class KadaneAlgo {
    // Finds max subarray sum
    public static int maxSum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            max = Math.max(max, sum);

            if(sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    // Finds range of max sum in subarray
    public static int[] maxRange(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        int ansStart = -1, 
            ansEnd = -1;
        int start = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum > max) {
                max = sum;
                ansEnd = i;
                ansStart = start;
            }
            
            if(sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        return new int[]{ansStart, ansEnd};
    }
}
