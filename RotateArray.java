// Time Complexity : O(n), n - > length of nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// On rotating the array by certain offset k, the last k elements need to appear in the beginning of the array.
// Considering this concept, we can reverse the entire array and reverse first k elements again.
// to retain back the order of first n-k elements, k+1 till n elements need to be reversed as well.

class Solution {
    public void rotate(int[] nums, int k) {
        // edge case
        if(nums == null || nums.length == 0 || k == 0)
            return;
        
        int n = nums.length;
        k = k % n; // considering k to be greater than n
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
