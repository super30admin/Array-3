/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(1)
* 
*/

public class RotateArray {
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];

        nums[start] = nums[end];

        nums[end] = temp;
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        if (k >= n) {
            k %= n;
        }

        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }
}