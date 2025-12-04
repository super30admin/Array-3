/**
 * 
 */

/**
 * @author Aditya Sinha
 * 
 * first reverse the two parts of the array split at n - k separately.
 * then  reverse the whole array to get the rotated result.
 * For left shift, reverse the whole array first, then reverse two parts accordingly.
 * 
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 *
 */
public class RotatingArrayKToRight {

	public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // Right shift
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);

        /* Left shift
        reverse(nums, 0, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        */
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
