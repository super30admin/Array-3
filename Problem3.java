// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Array-3;

public class Problem3 {
    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            //rotating the complete array by 10 times will have the same array
            k = k%nums.length;
        }
        //rotate the whole array
        rotateArray(nums, 0, nums.length -1);
        //rotate k elements
        rotateArray(nums, 0, k -1);
        //rotate n-k elements
        rotateArray(nums, k, nums.length - 1);
    }

    private void rotateArray(int[]nums, int l, int r){
        // System.out.println
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
