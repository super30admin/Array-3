// Time Complexity : O(N) - As we iterate the whole array
// Space Complexity : O(1) - As we rotate the elements in-space without using any additional data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
// Your code here along with comments explaining your approach