//Time complexity=O(N)
//Space complexity=O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Here we are initially reversing the entire array, then we are reversing the 1st k element and then separately reversing the k to n-1 elements. 
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length<2)
            return;
        int n=nums.length;
        k=k%n;//If k is larger than size of array we are doing % operation to obtain the value of k
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[] nums,int start,int end)
    {
        while(start<end){
        swap(nums,start,end);
        start++;
        end--;
        }       
        
    }
    private void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}