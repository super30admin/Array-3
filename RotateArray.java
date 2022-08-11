// Time Complexity : O(n+k)=O(n) to reverse an entire array and then reverse part of array(k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.Arrays;

class RotateArray {
    public int[] rotate(int[] nums, int k) {
        if(nums==null || nums.length==0) return nums;
        k = k%nums.length;
        int n = nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        return nums;
    }

    private void reverse(int [] nums, int l, int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String [] args){
        RotateArray ra = new RotateArray();
        System.out.println(Arrays.toString(ra.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }
}