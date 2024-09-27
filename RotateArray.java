class Solution {

    /**
     Rotate whole array, rotate first k, rotate n-k
     TC: O(n)
     SC: O(1)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k > nums.length) {
            k = k % n;
        }

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int low, int high) {
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
