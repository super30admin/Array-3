// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Appraoch
we are doing a 3 pass reverse,
first we check if k is bigger then nums length, if len 3 and k is 4, 4 rotation will be same as one rotation
then we rotate the first k element to fix there option and last reverse to fix the rest of the array
*/
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        if (k > nums.length)
            k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}