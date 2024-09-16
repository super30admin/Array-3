// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(0,nums.length-1,nums);
         reverse(0,k-1,nums);
         reverse(k,nums.length-1,nums);   
    }
    private void reverse(int start,int end, int[] nums){
        while(start<end){
            
            swap(start,end,nums);
            end--;
            start++;
            
        }
    }
    private  void swap(int i,int j,int[] nums){
        int temp = 0;
         temp=nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}