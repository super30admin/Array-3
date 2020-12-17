//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None
package com.s30.satish;

class Rotate_Array_189 {
    public void rotate(int[] nums, int k) {
        int l = 0, r = nums.length-1;
        if(k >= nums.length)
            k = k % nums.length;
        while(l <= r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        l = 0;
        r = k-1;
        while(l < r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        l = k;
        r = nums.length-1;
        while(l < r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public static void main(String[] args)
    {
    	int[] arr = {1,2,3,4,5,6,7};
    	Rotate_Array_189 ra = new Rotate_Array_189();
    	ra.rotate(arr, 5);
    }
}