import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        k = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    public void rotate(int[] nums, int left, int right) {
        while (left < right) {
            int num = nums[left];
            nums[left++] = nums[right];
            nums[right--] = num;
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();

        // Example input array
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        solution.rotate(nums, k);

        // Print the rotated array
        System.out.println("Rotated Array: " + Arrays.toString(nums));
    }
}
