public class problem3 {

    // Time Complexity: 0(n)
    // Space Complexity:0(1)
    public void rotate(int[] nums, int k) {

        int n= nums.length;
        k=k%n;

        reverse(nums, 0, n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0, n-1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start,end);
            start++;end--;
        }

    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
