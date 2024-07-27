//time - O(n), space - O(1)
class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        if(k >= n) {
            k = k % n;
        }
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, 0, n-1);
    }
    private void reverse(int[] nums, int start, int end) {
        if(start < 0 || start >= nums.length || end < 0 || end >= nums.length) {
            return;
        }
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
