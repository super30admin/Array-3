// Time Complexity = O(n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// We reverse the entire array and then we reverse the firse k elements, and the rest k elements
// Note: Make sure k is <= nums.length, so do a mod and get it in range
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length==0) return;
        int n = nums.length;
        if (k>n) {
            k = k%n;
        }

        rotate(nums, 0, n-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, n-1);
    }

    private void rotate(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}