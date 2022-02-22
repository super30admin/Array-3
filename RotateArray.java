// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length < 2) return;
        k = k % nums.length;
        int n = nums.length-1;
        reverse(nums, 0 , n);
        reverse(nums, 0, k-1);
        reverse(nums, k, n);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}