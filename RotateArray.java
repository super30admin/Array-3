// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public void rotate(int[] nums, int k) {
        
        if(k == 0) return;
        int n = nums.length;
        
        k = k % n;
        
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while(start <= end) {
            swap(nums, start++, end--);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}