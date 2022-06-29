// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class RotateArray {
        public void rotate(int[] nums, int k) {
            // null case
            int n = nums.length;
            if(nums == null) return;
            if(k > n) {
                k = k % n;
            }
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int l, int r) {
            while(l < r) {
                swap(nums, l, r);
                l++; r--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}
