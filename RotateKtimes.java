// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//initially we reverse the whole array and then our k elements would come front
//so we reverse the first k elements , and then reverse the remaining elements 
//we will have our result
//we take modulus of k with length of array to have the right 'k' within the size of array

class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0,k-1);
        reverse(nums,k,nums.length-1);
        
        
        }
    public void reverse(int[] nums, int start, int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
        
    }