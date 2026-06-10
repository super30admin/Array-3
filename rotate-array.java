// Time Complexity : O(n) because we reverse the array a constant number of times
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We rotate the array by reversing the entire array first.
// Then we reverse the first k elements and the remaining n-k elements separately.
// These three reversals place every element into its correct rotated position in O(1) extra space.

class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        // reverse entire array
        reverse(nums, 0, n - 1);

        // reverse first k elements
        reverse(nums, 0, k - 1);

        // reverse remaining elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}