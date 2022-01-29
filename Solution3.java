// Time Complexity :O(n)= length of array
// Space Complexity :O(1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==0||nums==null)
            return;
        int n=nums.length;
        if(k>n)
            k=k%n;
        
        //reverse the array
        reverse(nums,0,n-1);
        //reverse 0to k-1 elements
        reverse(nums,0,k-1);
        // reverse the rest of the array
        reverse(nums,k,n-1);
        
        return;
    }
    private void reverse(int [] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
        return;
    }
    private void swap(int [] nums, int i,int j){
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
        return;
    }
}