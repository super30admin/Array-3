// Time Complexity :o(N)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public void rotate(int[] nums, int k) {
        
        if(nums == null || nums.length == 0 )
            return;
        
        k=k%nums.length; //k > n
        
        reverse(nums,0,nums.length-1); //n
        reverse(nums,0,k-1); //k
        reverse(nums,k,nums.length-1); //n-k reverse
    }
    
    private void reverse(int[] nums,int left,int right)
    {
        while(left<right)
        {
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            
            left++;
            right--;
        }
    }
}