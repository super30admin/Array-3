class Solution {
    //(O(1) space and O(n) time
    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        if (k >= n) k = k%n;
        //Right Rotate
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        //Left Rotate
        //reverse(nums, 0, n - 1);
        //reverse(nums, 0, n - k - 1);
        //reverse(nums, n - k, n - 1);

    }

    private void reverse(int[] nums, int start, int end) {

        while (start < end) {

            swap(nums, start, end);
            start++; end--;

        }

    }

    private void swap(int[] nums, int start, int end) {

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}