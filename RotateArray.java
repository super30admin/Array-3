// Time Complexity : O(n) --> where n is the length input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (189): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // edge case
        if (nums == null || n < 2) return;
        if (k > n) k = k % n; 
        
        reverse(nums, 0, n-1); // reverse the whole array
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++; r--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}