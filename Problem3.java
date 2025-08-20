// Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// we reverse first half, reverse second half and then reverse complete array.

class Solution {
    public void rotate(int[] nums, int k) {
        if(k>=nums.length) k =k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        return;
    }
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}