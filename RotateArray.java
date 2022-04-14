public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }

        int n = nums.length - 1;

        //  reverse the entire array
        reverse(nums, 0, n);

        //  reverse in parts
        reverse(nums, 0, k-1);
        reverse(nums, k, n);
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
