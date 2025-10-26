//TC: O(n), SC: O(1)
//Approach: First reverse the whole array
//Then reverse the first k elements again, then reverse the elements from k -> n
public class RotateArray {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length < 2) return;
        if (k > nums.length) k = k % nums.length;

        helper(nums, 0, nums.length - 1);
        helper(nums, 0, k - 1);
        helper(nums, k, nums.length - 1);
    }

    private void helper(int[] nums, int i, int j) {

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}
