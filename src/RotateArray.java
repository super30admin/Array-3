
/*
 * The complexity of the algorithm is O(n) where n is no of elements in array.
 * 
 */

public class RotateArray {

	public void rotate(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return;
		int n = nums.length;
		if (k >= n)
			k = k % n;

		reverse(nums, 0, n - 1);

		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);

	}

	private void reverse(int[] nums, int i, int j) {

		while (i <= j) {

			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
