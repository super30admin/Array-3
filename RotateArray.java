// https://leetcode.com/problems/rotate-array/

// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums == null || n == 0 || n == 1) return;
        if( k > n) {
            k = k%n;
        }
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
