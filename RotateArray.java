// TC - O(n), SC - O(1)

// LC - 189

class Solution {
    public void rotate(int[] nums, int k) {
		// If k is greater than nums.length, k%nums.length number of rotations will be same as k rotations
        k = k % nums.length;
		// reverse entire array, then reverse first k-1 elements and then rotate from k to end of array
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

	// reverse function
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}