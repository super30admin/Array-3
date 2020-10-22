// TC: O(N) since we are traversing through the entire array
// SC: O(1) constant space

public class rotateArray {

	public void rotate(int[] nums, int k) {
		
//		k %= nums.length; // incase, if the value of k is greater than length of array, we update our k value.
//		
//		reverse(nums, 0, nums.length-1); // reverse the complete array,// 7 6 5 4 3 2 1
//		reverse(nums, 0, k-1);  // reverse the first k elements // 5 6 7 4 3 2 1
//		reverse(nums, k, nums.length-1); // reverse the remaining len - k elements // 5 6 7 1 2 3 4
		
		int cnt = 0;
		for(int st =0;cnt<nums.length;st++) {
			int curr = st;  // retrieve the current index
			int prev = nums[curr];  //we will consider the curr as the prev element so that we can swap with the next kth element
			// swap the elements in the array with curr+kth index and curr index.
			do {
				int next = (curr+k) % nums.length;  // retrieve the next number in array
				int temp = nums[next];  // store the next in temp var
				nums[next] = prev;  // swap the next with prev numbers
				prev = temp;
				curr = next; // update the next as current index
				cnt++;
			}while(st!=curr);  // once our curr becomes equal to start, we will increment our start pointer and update the current and 
			// we keep swapping the elements.
		}
	}
	
	public void reverse(int[] nums, int st, int end) {
		
		// code to reverse the array(swap elements)
		while(st < end) {
			int temp = nums[st];
			nums[st] = nums[end];
			nums[end] = temp;
			st++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		
		rotateArray ra = new rotateArray();
		int[] nums = {1, 2 ,3, 4, 5, 6, 7};
		ra.rotate(nums, 3);
		for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]);
		}
	}
}
