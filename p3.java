// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(k==0) return;
        //Reverse the whole array
        for(int i=0; i<nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = temp;
        }

       
        //Reverse first k elements
        for(int i=0; i<k/2; i++){
            int temp = nums[i];
            nums[i] = nums[k-1-i];
            nums[k-1-i] = temp;
        }

        //Reverse remaining elements
        for(int i=k; i<(nums.length+k)/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-1-i+k];
            nums[nums.length-1-i+k] = temp;
        }

         
    }
}