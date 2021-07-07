
//Time Complexity : O(N) 
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
We have used DP to cache the result of recursive apporach to avoid re-computation 
*/


class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}