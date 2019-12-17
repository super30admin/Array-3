package demo;

public class RotateArray {

	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		//reverse entire array
		reverse(nums, 0, nums.length-1);
		//reverse from 0 to k-1
		reverse(nums, 0 , k-1);
		//reverse remaining till end
		reverse(nums, k , nums.length-1 );
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	private static void reverse(int [] nums, int low , int high) {
		while(low < high) {
			int temp = nums[low];
			nums[low] = nums[high];
			nums[high] = temp;
			low++;
			high--;
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		rotate(arr, 3);
	}
}