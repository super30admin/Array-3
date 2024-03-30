// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Without using extra space:-
 *  1. Reverse first k elements
 *  2. Reverse last n-k elements
 *  3. Reverse the complete array
 */


public class Problem3 {
    public void rotate(int[] nums, int k) {
        //1. Reverse first k elements
        //2. Reverse last n-k elements
        //3. Reverse the complete array

        int n = nums.length;
        if(k >= n) {
            k = k % n;
        }


        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
