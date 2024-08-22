// TC: O(n) , sc:O(1);
class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        swap(nums,0,nums.length-1);
        swap(nums,0,k-1);
        swap(nums,k,nums.length-1);
    }

    private void swap(int [] nums, int l, int r){
        while(l<r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        l++;
        r--;
        }
    }
}