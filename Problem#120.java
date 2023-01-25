// Rotate Array

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return;
        int n = nums.length;
        k = k % n;
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, 0, n-1);
    }

    private void reverse(int[] nums, int low, int high){
        int temp;
        while(low < high){
            temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
            low++;
            high--;
        }
    } 
}