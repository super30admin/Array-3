//Time complexity is O(n)
//Space complexity is O(1)
//This solution is submitted on leetcode

public class BigN117RotateArrayForGivenK {
	class Solution {
		public void rotate(int[] nums, int k) {
			// edge case
			if (nums == null || nums.length == 0)
				return;
			int len = nums.length;
			// important edge case
			if (k > len)
				k = k % len;
			reverse(nums, 0, len - 1); 
			reverse(nums, 0, k - 1);
			reverse(nums, k, len - 1);
		}

		private void reverse(int[] nums, int i, int j) {
			while (i <= j) {
				swap(nums, i, j);
				i++;
				j--;
			}
		}

		private void swap(int[] nums, int i, int j) {
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}
	}
}