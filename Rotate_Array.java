//TC - O(N)
//SC - O(1)
class Solution {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length < 2)
			return;
		int n = nums.length;
		if (k > n)
			k = k % n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	public void reverse(int nums[], int l, int r) {
		while (l < r) {
			swap(nums, l, r);
			l++;
			r--;
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}