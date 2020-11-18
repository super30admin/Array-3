// Time Complexity: O(N)
// Space Complexity: O(1)
// Passed Leetcode

class Solution {
    
    public void reverse(int[] nums, int start, int end) {
        
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int rotate = k % nums.length;
        
        if (rotate == 0)
            return;
        
        reverse(nums, 0, nums.length - 1);
        
        reverse(nums, 0, rotate - 1);
        reverse(nums, rotate, nums.length - 1);
        
    }
}