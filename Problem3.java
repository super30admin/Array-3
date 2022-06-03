import java.util.Arrays;

public class Problem3 {

    // TC : O(n)
    // SC : O(1)
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;

        int n = nums.length;
        if (k > n) k = k % n;
        reverse(nums, n - k, n - 1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        System.out.println("inside reverse loop");
        while (i <= j) {
            System.out.println("nums[i]" + nums[i]);
            System.out.println("nums[j]" + nums[j]);
            System.out.println("*****");
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
