// Time Complexity - O(2n) where n is the length of the nums array
// Space Complexity - O(1)  since no extra space is used the rotation is done in place
// This Solution worked on LeetCode 

class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;             // k% so as to get a valid k value if the k is greater than the length of the nums.
        
        reverse(nums,0,nums.length-1);  // reverse the nums array
        reverse(nums,0,k-1);                // reverse the reversed part of the array from 0 to 2 if k=3
        reverse(nums,k,nums.length-1);  // reverse the reversed part of the array from 3 to length-1 if k=3
    }
    public void reverse(int[] nums, int start,int end)
    {
        while(start<end)
        {
            int temp=nums[start];           // reverse the start and end values, increment the start and decrement the end until they dont cross
            nums[start]=nums[end];
            nums[end]=temp;
            
            start++;
            end--;
        }
    }
}
