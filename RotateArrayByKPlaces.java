// In this problem, reversing the entire array, that will get the elements from end to the start. We want end elements to the start 
// bcoz we have to rotate right. Now, starting k elements reverse them, and then reverse k to n-1 elements. 

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public void rotate(int[] nums, int k) {
        // Base case
        if (nums == null || nums.length == 0) {
            return;
        }
        // Length
        int n = nums.length;
        // If is k greater than n, bring it in range of n
        k = k % n;
        // Reverse entire array first
        reverse(nums, 0, n - 1);
        // Then reverse 0 to k-1 elements
        reverse(nums, 0, k - 1);
        // Then reverse k to n-1
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        // For reversing, swap left and right values and do this till left is less than
        // right
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int l, int r) {
        // For swapping store first in temp
        int temp = nums[l];
        // update first
        nums[l] = nums[r];
        // update second
        nums[r] = temp;
    }
}