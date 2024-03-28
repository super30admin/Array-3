package week10.day1;
//TC - O(n)
//SC - O(1)
class Solution28 {
	public void rotate(int[] nums, int k) {
		System.out.println(nums.length);
		System.out.println(k);
		if (nums.length < k)
			return;
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start <= end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}

public class RotateArrayByK {

	public static void main(String[] args) {
		/*
		 * int[] height = { 1, 2, 3, 4, 5, 6, 7 }; Solution28 s2 = new Solution28();
		 * s2.rotate(height, 3);
		 */
		int[] height = { 1, 2 };
		Solution28 s2 = new Solution28();
		s2.rotate(height, 3);
	}

}
