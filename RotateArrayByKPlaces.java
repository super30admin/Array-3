// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public void rotate(int[] nums, int k) {

        int n=nums.length;
        k=k%n; //for no of rotations >n, only the remaining rotations counts

        reverse(nums, 0,n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k,n-1);

    }
    private void reverse(int nums[], int l, int r){

        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
    private void swap(int nums[], int l, int r ){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}