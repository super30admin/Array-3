// Time Complexity : O(n), n -> Number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

public class RotateArrayByKPlaces {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int n = nums.length;
		k = k % n;

		if (k == 0) {
			return;
		}

		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	private void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RotateArrayByKPlaces obj = new RotateArrayByKPlaces();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;

		System.out.println("Initial Array: ");
		obj.print(nums);
		obj.rotate(nums, k);
		System.out.println("Rotated Array: ");
		obj.print(nums);
	}

}
