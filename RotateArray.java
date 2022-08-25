//Time Complexity: O(2n) = O(n)
//Space Complexity: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        int n = nums.length;
        k = k % n; // making sure the value of k doesnt exceed the value of n

        // reverse solution
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);

    }

    private void reverse(int[] nums, int left, int right) {
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}