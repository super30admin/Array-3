// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    /** first we mod k by length of array because if k = length of array then array remains the same.
     * we first reverse the entire array then reverse from 0 to k-1 th element separately from
     * kth to n-1th element which gives us the rotated array **/
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(k==0){
            return;
        }

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        return;


    }

    public void reverse(int[] nums,int left, int right){
        int temp=0;
        while(left<right){
            temp=nums[right];
            nums[right]=nums[left];
            nums[left]=temp;
            left++;
            right--;
        }

    }
}