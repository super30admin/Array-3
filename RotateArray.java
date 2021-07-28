// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * 1. reverse total array.
 * 2. reverse first k elements
 * 3. reverse last n-k elements
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {

		int n = nums.length;

		if (k >= n)
			k = k % n;

		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);

	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private void swap(int[] nums, int in1, int in2) {
		int temp = nums[in2];
		nums[in2] = nums[in1];
		nums[in1] = temp;
	}
}
