//## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// we reverse the whole array, then reverse from trarting to k-1, then k to n-1. This replicates the behavior of moving array by k places

class Solution {
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        if(nums==null || nums.length==0 || k%n==0)
        {
            return;
        }

        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int[] nums, int l, int r)
    {
        int temp;
        while(l<r)
        {
            temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}