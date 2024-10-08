// TC: O(n)
// SC: O(1)
class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // if k>n, we ultimately do the same reversing again.
        k = k%n;
        if(k == 0) return;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}