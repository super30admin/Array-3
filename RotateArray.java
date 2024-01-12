public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;
        k = k % n;  // Handle cases where k is greater than n

        reverse(nums, 0, n - 1); //reversing entire array
        reverse(nums, 0, k - 1); // reversing the k elements
        reverse(nums, k, n - 1); // reversing rest of the elements
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
