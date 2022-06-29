// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k % n;
        }
        // reverse whole array
        reverse(nums, 0, n - 1);
        // reverse 0 to k-1
        reverse(nums, 0, k - 1);
        // reverse rest array
        reverse(nums, k, n - 1);
    }

    public void swap(int[] nums, int i, int j) {
        // swap two numbers using mathematical approach
        if (i != j) {
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }

    public void reverse(int[] nums, int i, int j) {
        // reverse array from i to j
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }
}