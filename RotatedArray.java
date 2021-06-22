// Time Complexity :  O(N) as there is only one pass to entire array
// Space Complexity : O(1) as its done in place.
// Did this code successfully run on Leetcode : Yes


class RotatedArray {
    public void rotate(int[] nums, int k) {
       
        // edge case if length of array is 0
        if(nums.length==0) return;
       
        // Check if k>nums.length then modulo will give actual k 
        if (k>=nums.length) k=k%nums.length;
        
        // reverse entire array
       reverse(nums,0,nums.length-1);
        
        //reverse k positions from 0 to k-1
        reverse(nums,0,k-1);
        
        // reverse second ha;f from k to end of array
        reverse(nums,k,nums.length-1);
        
    }
    
    // reverse function
    public void reverse(int[] nums, int left, int right){
        
         while(left<right){
            
            swap(nums,left,right);
            left++;
            right--;
            
        }
        
    }
    
    //swap function
    public void swap(int[] nums, int left, int right){
        
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}