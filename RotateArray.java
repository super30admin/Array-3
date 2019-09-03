
public class RotateArray {
	/*Time complexity : O(n)O(n). One pass is used to put the numbers in the new array. And another pass to copy the new array to the original one.

	Space complexity : O(n)O(n). Another array of the same size is used.*/
	//iterate over array and create new array  and insert value at kth index% arraylength by current value.

	    public void rotate(int[] nums, int k) {
	        int[] a = new int[nums.length];
	        for (int i = 0; i < nums.length; i++) {
	            a[(i + k) % nums.length] = nums[i];
	        }
	        for (int i = 0; i < nums.length; i++) {
	            nums[i] = a[i];
	        }
	    }
	
	//tc:o(n)
	   //sc :o(1)
	    //for first k elements replace current+kth element by current element .continue this  till end of array.
	        public void rotate2(int[] nums, int k) {
	            k = k % nums.length;
	            int count = 0;
	            for (int start = 0; count < nums.length; start++) {
	                int current = start;
	                int prev = nums[start];
	                do {
	                    int next = (current + k) % nums.length;
	                    int temp = nums[next];
	                    nums[next] = prev;
	                    prev = temp;
	                    current = next;
	                    count++;
	                } while (start != current);
	            }
	        }
	    
}
