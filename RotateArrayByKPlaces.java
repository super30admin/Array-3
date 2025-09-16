class Solution {
    // one method is create 2 new arrays. copy from main array. finally store original arrray with second and the first array. Below method is in place.

    // TC O(n) SC O(1)
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }

        int n = nums.length;
        k = k % n;
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
        
    }

    private void reverse(int nums[], int left, int right) {
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int nums[], int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}