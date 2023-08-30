// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Reverse the whole array.
 * 2. Reverse the first k elements.
 * 3. Reverse the remaining elements.
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if(k == 0)
            return;
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int left, int right){
        while(left <= right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}