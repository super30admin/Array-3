// Time complexity: O(n) where n is the length of the nums array
// Space complexity: O(1) for using constant space
// LeetCode Problem: https://leetcode.com/problems/rotate-array/

// Intuition: The problem can be solved using the reverse method.
// First we reverse the entire array, 
// then we reverse the first k elements 
// and finally we reverse the remaining n-k elements.
// This approach ensures that the elements are rotated to the right by k positions in an efficient manner.

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int l, int r) {
        while (l <= r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}
