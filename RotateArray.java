public class RotateArray {

    // TC : O(n) n - number of elements in nums array
    // SC : O(1)
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;

        int n = nums.length;
        if(k > n) k = k % n;

        reverse(nums, 0,n - k - 1);
        reverse(nums,n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int low, int high) {

        while(low <= high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
