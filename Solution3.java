// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution3 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int index = k % n;
        if( index == 0 ) {
            return;
        }
        reverse(nums, 0 , n-index-1);
        reverse(nums, n-index, n-1);
        reverse(nums, 0, n-1);
    }

    public void reverse(int[] nums, int i, int j) {
        while( i < j ) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}