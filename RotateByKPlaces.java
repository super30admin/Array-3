/***
 Optimized approach
 1. Reverse the array (0-n-1), then reverse array from index(0 to k-1), then reverse from index (k, n-1).
 TC - O(n)
 SC - O(1)
 */
class RotateByKPlaces {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return;

        int n = nums.length;

        if(k > n) {
            k = k%n;
        }

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}