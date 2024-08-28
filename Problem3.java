//Time = O(n)
//Space = O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        // Reduce the value of k to a value that is less than the length of the array
        k = k % nums.length;
        
        // Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }
    
    // Helper function to reverse an array in-place
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
