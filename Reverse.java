// Time complexity is O(num length)
// Space complexity is O(1)

public class Reverse {
    public void rotate(int[] nums, int k) {

        if (nums.length == 0 || k < 1)
            return;
        if (k >= nums.length)
            k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int l, int k) {
        int temp = nums[l];
        nums[l] = nums[k];
        nums[k] = temp;
    }
}
