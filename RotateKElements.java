
/**
 * Url: https://leetcode.com/problems/rotate-array/
 * Title: 189. Rotate Array
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RotateKElements {

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        if(nums.length == 1) {
            return;
        }
        k = k % nums.length;
        reverse(0, nums.length -1, nums); // reverse the whole array

        int i = 0;
        int j = k - 1;
        reverse(i, j, nums); // reverse the first k elements

        i = k;
        j = nums.length - 1;
        reverse(i, j, nums); // reverse the rest of the elements
    }

    private void reverse(int i, int j, int[] nums) {
          while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        new RotateKElements().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
