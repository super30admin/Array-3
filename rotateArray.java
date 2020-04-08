// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//it's a trick that we need to know from before
//to avoid repeated rotation, find modulo of k with n (n = length of array)
//first reverse the whole array
//then reverse from start to k-1
//then reverse from k to length-1

class Solution {
    public void rotate(int[] nums, int k) {
       
        //base check
        if(nums == null || nums.length == 0) return;
        
        int n = nums.length;
        
        //if the k is greater than the length of array then we are repeating the rotations. Therefore, we need to find the modulo of k with n
        k = k%n;
        System.out.println(k);
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}