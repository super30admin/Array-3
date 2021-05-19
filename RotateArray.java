//Time Complexity : O(N)
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return;
        }
        k = k % nums.length; // to support thr case if k>=nums.length
        //reverse the input array
        reverse(nums,0,nums.length-1);
        //reverse the first k-1 elements
        reverse(nums,0,k-1); //reverse(nums,0,nums.length-k-1); to rotate by left
        //reverse the k-n elements
        reverse(nums,k,nums.length-1); // reverse(nums,nums.length-k,nums.length-1);//to rotate by left
    }
    private void reverse(int[] nums,int start,int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}