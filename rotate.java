// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        // Step 1: Calculate the effective number of rotations needed
        // If k is larger than the length of the array, rotating by k is the same as rotating by k % length
        int length = nums.length;
        k = k % length;

        // Step 2: Reverse the entire array
        reverse(0, length - 1, nums);

        // Step 3: Reverse the first k elements
        reverse(0, k - 1, nums);

        // Step 4: Reverse the remaining elements from index k to the end
        reverse(k, length - 1, nums);
    }

    // Helper method to reverse a portion of the array between start and end indices (inclusive)
    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            // Swap the elements at start and end indices
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            // Move towards the center
            start++;
            end--;
        }
    }
}
