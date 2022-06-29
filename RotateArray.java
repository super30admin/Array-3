//https://leetcode.com/problems/rotate-array/
// Time Complexity :O(n)  
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(k>n)
        {
            k=k%n;
        }
        reverse(nums,0,n-1); //reverse full array
        reverse(nums,0,k-1); //reverse first k elements
        reverse(nums,k,n-1); //reverse last n-k elements
        
    }
    private void reverse(int[] nums,int i,int j)
    {
        while(i<j)
        {
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    private void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}