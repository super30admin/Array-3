//Time Complexity- O(n)
//Space Complexity - O(1)
//Sucessfully ran on leetcode

class Solution {
 public void rotate(int[] nums, int k) {
     
     if(nums == null || nums.length==0) return;
     
     int n = nums.length;
     k = k % n;
     reverse(nums , n-k , n-1);
     reverse(nums, 0 , n-k-1);
     reverse(nums , 0 , n-1);
   }
 private void reverse(int[] nums, int left, int right){
      while(left < right){
           swap(nums, left , right);
          left++;
          right-- ;
      }
     
 }
 private void swap(int[] nums, int x, int y){
     int temp = nums[x];
     nums[x]= nums[y];
     nums[y]= temp;
 }
}