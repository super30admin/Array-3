// Time Complexity : O(n), We traverse once through the array.
// Space Complexity : O(1), No extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void rotate(int[] nums, int k) {
//A special case where value of k for rotation exceeds the array length.
        if(k>nums.length){
            k = k%nums.length;
        }
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    public void reverse(int[] nums, int l, int r){
        while(l<=r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
    public void swap(int[] nums, int l, int r){
        int temp;
        temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}