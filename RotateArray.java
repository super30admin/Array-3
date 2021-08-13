package Array3;

public class RotateArray {
    /* Created by palak on 8/13/2021 */

    /**
     Time Complexity: O(n)
     Space Complexity: O(1)
     */
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return;
        int n = nums.length;
        if(k >= n) k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    private void reverse(int[] nums, int left, int right) {
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

    public static void main(String[] args) {

    }
}
