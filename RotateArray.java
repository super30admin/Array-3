// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class RotateArray {
    class Solution {
        public void rotate(int[] nums, int k) {
            //if array length is 5 and k = 12, then we can skip 2 complete rotation i.e jjust rotate (12 % 5) 2 more time
            k = k % nums.length;

            //first reverse entire array
            reverseArray(nums, 0, nums.length-1);

            //reverse first k element
            reverseArray(nums, 0, k-1);

            //reverse remaining elements
            reverseArray(nums, k, nums.length-1);

        }

        private void reverseArray(int[] nums, int start, int end) {
            int l = start;
            int r = end;

            while(l<r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
    }
}
