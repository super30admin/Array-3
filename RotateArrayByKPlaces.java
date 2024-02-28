// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yess
// Three line explanation of solution in plain english:

// Your code here along with comments explaining your approach:Reverse the array 

class Solution {
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        int start=0;
        int end=n-1;
        if(k>=n){
            k=k%n;
        }
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);  

    }
    public void reverse(int nums[], int start, int end){
        while(start<=end){
            int temp= nums[start];
            nums[start]= nums[end];
            nums[end]= temp;

            start++;
            end--;
        }
    }
}