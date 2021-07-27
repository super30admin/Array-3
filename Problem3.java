
// Time - O(N)
// Space - O(1)


class Solution {
    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length == 0) return;
        int n = nums.length;

        if(k >= n) k = k%n;

        reverse(nums,0,n-1); // reverse the whole array first
        reverse(nums,0,k-1); // reverse k elements
        reverse(nums,k,n-1); // reverse n - k elements



    }

    public void reverse(int [] nums, int l, int r) {

        while(l < r) {

            swap(nums,l,r);
            l++;r--;

        }


    }

    public void swap(int [] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;


    }
}