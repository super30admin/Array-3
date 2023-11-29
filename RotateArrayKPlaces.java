// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class RotateArrayKPlaces {
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;

            reverse(nums, 0, n-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, n-1);
        }

        private void reverse(int[] nums, int l, int r){
            while(l <= r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
    }
}
