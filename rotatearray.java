//t.c O(n), becase it call reverse function 3 time and each time it takes O(n)
//s.c O(1), no additional daat structure only temp variable
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1); //reverse all elements
        reverse(nums, 0, k-1); //reverse first k elements
        reverse(nums, k, nums.length-1); //reverse the remaining last elements

    }
    public void reverse(int[] nums, int start, int end){
      while(start< end){
        int temp= nums[start];
        nums[start]= nums[end];
        nums[end]= temp;
        start++;
        end--;

      }
    }
}