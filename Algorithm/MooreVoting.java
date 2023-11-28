package Algorithm;

/*
 * Moore's Voting Algorithm
 * It is used to find the majority element (appearing > N/2 times) in an array
 * Initially, we initialize element = first_element and count = 0
 * We iterater the whole array from 0 till N
 * If the current element == element, then increment the count
 * otherwise decrement it.
 * If at any certain point, the count == 0, then update the element variable to store next element and repeat the above process from that element itself.
 * No need to start from beginning.
 * 
 * At the end of array, the element in element variable might represent majority element (it may or may not be majority element in case if array doesn't have any majority element).
 * To verify, iterate through the loop and calculate the count of the element and return answer accordingly
 * 
 * Time Complexity: O(2n) = O(n)
 * Space Complexity: O(1)
 */

public class MooreVoting {
    public static int findMajority(int[] arr) {
        int element = arr[0],
            count = 1;

        for(int i = 1; i < arr.length; i++) {
            if (count == 0) {
                element = arr[i];
                count++;
            } else if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == element) count++;
        }

        return (count > (arr.length / 2)) ? element : -1;
    }
}
