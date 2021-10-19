// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public void rotate(int[] nums, int k) {
        // null
        if(nums == null) return;
        
        int n = nums.length;
        k = k%n;
        reverse(nums,0,n-1-k);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    private void reverse(int[] nums, int l, int r){
        while(l<r){
            swap(nums, l, r);
            l++; r--;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}