// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return;

        int n = nums.length;
        k = k % n;     // For edge cases & k>nums.length

        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, 0, n-1);
    }

    public void reverse(int[] nums, int left, int right){
        while(left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right--;
        }
    }
}