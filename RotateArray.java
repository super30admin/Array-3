import java.util.Arrays;

//Time Complexity : O(n)
//Space Complexity : O(1)
public class RotateArray {	
	/**Approach: Array Reverse**/
	public void rotate(int[] nums, int k) {
        int n= nums.length;        
        if (k >= n) k=k%n;           
        reverse(nums, 0, n-1); //reverse the whole array        
        reverse(nums, 0, k-1); //reverse first k elements        
        reverse(nums, k, n-1); //reverse rest n-k elements          
    }
    private void reverse(int[] nums, int start, int end){        
        while(start < end){
            int temp= nums[start];
            nums[start]= nums[end];
            nums[end]= temp;
            start++;
            end--;
        }
    }

    // Driver code to test above
	public static void main (String[] args) {
		RotateArray ob= new RotateArray();
		int[] arr= {1,2,3,4,5,6,7};
		int k=3;		
		ob.rotate(arr, k);
		System.out.println("Rotated array: "+ Arrays.toString(arr));				
	}
}
