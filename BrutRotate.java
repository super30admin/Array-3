/**
 * BrutRotate time complexity is O(num length * k), -> space complexity is O(1)
 */
public class BrutRotate {

    public void rotate(int[] nums, int k) {

        if (nums.length == 0 || k < 1)
            return;

        for (int i = 0; i < k; i++) {
            int swapVal = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = swapVal;
                swapVal = temp;
            }
        }

    }
}