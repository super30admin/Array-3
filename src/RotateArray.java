//Time Complexity : O(N) 
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Swap first n-k elements and then swap next n-k to n elements. Then swap the
 * entire array. This will give the expected result.
 *
 */
class Solution {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		if (n == 1)
			return;
		swap(nums, 0, n - k - 1);
		swap(nums, n - k, n - 1);
		swap(nums, 0, n - 1);
	}

	public void swap(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
}