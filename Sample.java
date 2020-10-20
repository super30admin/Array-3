//Rotate Array
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public void rotate(int[] nums, int k) {
        if(k>nums.length)
            k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    
    private void reverse(int[] nums, int start, int end)
    {
        while(start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}

//Trapping Rain Water
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int trap(int[] height) {
       if(height ==null || height.length==0)
           return 0;
        int L=0;
        int R=height.length-1;
        int LW=0;
        int RW=0;
        int total=0;
        while(L<=R)
        {
            if(LW<RW)
            {
                if(LW<height[L]){
                    LW=height[L];
                }
                else{
                    total+= LW-height[L];
                }
                L++;
            }
            else{
                if(RW<height[R]){
                    RW=height[R];
                    
                }
                else{
                    total+=RW-height[R];
                }
                R-=1;
            }
        }
    }
}
