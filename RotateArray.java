package array3;

public class RotateArray {
	//Time Complexity : O(n), where n is length of nums array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public void rotate(int[] nums, int k) {
        // null
        if(nums == null || nums.length == 0 || k == 0)
            return;
        
        k = k % nums.length;
        
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    
	//Time Complexity : O(n), where n is length of nums array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public void rotate1(int[] nums, int k) {
        // null
        if(nums == null || nums.length == 0 || k == 0)
            return;
        
        k = k % nums.length;
        
        reverse1(nums, 0, nums.length - 1);
        reverse1(nums, 0, k - 1);
        reverse1(nums, k, nums.length - 1);
    }
    
    private void reverse1(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    
	//Brute Force
	//Time Complexity : O(n*k), where n is length of nums array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : TLE
	//Any problem you faced while coding this : No
	public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        while(k > 0) {
            int last = nums[nums.length - 1];
            int first = nums[0];
            nums[0] = last;
            for(int i=1; i<nums.length; i++) {
                int temp = nums[i];
                nums[i] = first;
                first = temp;
            }
            k--;
        }
    }
}
