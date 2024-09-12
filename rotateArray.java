// Time complexity: O(N)
// Space complexity: O(1)

class Solution {
    public void rotate(int[] nums, int k) {  
        if (nums == null || nums.length==0 || k < 0) {
		throw new IllegalArgumentException("Illegal argument!");
	    }
        
        if(k > nums.length){
		    k = k %nums.length;
	    }
        
        int a = nums.length - k;
        reverse(nums, 0, a-1);
        reverse(nums, a, nums.length - 1); 
        reverse(nums, 0, nums.length - 1);     
    }
    
    public void reverse(int[] nums, int start, int end)
    {
        if(nums == null || nums.length == 1) 
		    return;
        while (start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}