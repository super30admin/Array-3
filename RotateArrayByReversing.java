// TC: O(n)
// SC: O(n)

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // reverse all
        reverse(nums, 0, n-1);
        // reverse 1st k elements
        reverse(nums, 0, k-1);
        // reverse last k elements
        reverse(nums, k, n-1);
    }
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}