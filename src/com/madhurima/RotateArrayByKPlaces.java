//Time complexity: O(n)
//Space Complexity: O(1)
//Did the code run successfully in LeetCode = yes

package com.madhurima;

public class RotateArrayByKPlaces {
}

class RotateArrayByKPlacesSolution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }

        int n = nums.length;
        k = k % n;

        // reverse(nums, 0, n-1);
        // reverse(nums, 0, k-1);
        // reverse(nums, k, n-1);

        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, 0, n-1);

    }

    private void reverse(int[] nums, int l, int r){
        while(l <= r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
