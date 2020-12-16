public class RotateArray {
	//time complexity ==> O(2n)
	//space complexity ==> O(1)
	public void rotate(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return;
		int n = nums.length;

		// if
		if (k >= n) {
			k = k % n;
		}
		// reverse the whole array
		reverse(nums, 0, n - 1);

		// swap from 0 to k
		reverse(nums, 0, k - 1); // right rotate

		// reverse(nums,n-k-1,n-1);// uncomment when left rotate is to be done

		// swap from k to n -1
		reverse(nums, k, n - 1); // right rotate

		// reverse(nums,n-k-1,0); //uncomment when left rotate is to be done
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {

			swap(nums, start, end);
			start++;
			end--;
		}

	}

	private void swap(int[] nums, int start, int end) {

		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;

	}

	public static void main(String[] args) {
		RotateArray arr = new RotateArray();

		arr.rotate(new int[] { 1 }, 4);
	}

}
