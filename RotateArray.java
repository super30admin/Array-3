// Time Complexity : O(m+n)= O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/rotate-array/
// Any problem you faced while coding this : No


class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    
    public static void reverse(int[] nums, int low, int high){
         while(low<high){
             swap(nums,low,high);
             low++;
             high--;
         }
    }
    
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
}
