//time:O(n)
//space:O(1)
//leetcode:yes

class Solution {
    public void rotate(int[] nums, int k) {
        //edge case
        if(nums == null || nums.length <2)return;
        int n = nums.length;
        //k can be larger than length
        if(k>n){
            k = k%n;
        }
        reverse(nums, 0, n-1);//reverse whole array
        reverse(nums, 0, k-1);//reverse first half
        reverse(nums, k, n-1);//reverse second half
    }
    private void reverse(int [] nums , int l, int r){
        while(l < r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    private void swap(int [] nums , int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}