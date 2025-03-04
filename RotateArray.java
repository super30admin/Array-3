/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Reverse all the elements of the array.
 * Reverse the first k elements.
 * Reverse the rest n−k elements.
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Your code here
    }
}