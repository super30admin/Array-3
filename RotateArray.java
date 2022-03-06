// Time Complexity : O(n), O(nlogn) + O(klogn) + O((n-k)log(n-k)
// Space Complexity : O(1) - No extra space as all reversals are in place
// Did this code successfully run on Leetcode : Yes

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;

        if(k >= n){
            k = k % n;
        }
        //reverse entire array
        reverse(nums, 0, n-1);
        //1. reverse first k elements
        reverse(nums, 0 , k-1);
        //2. reverse last n-k elements
        reverse(nums, k , n-1);
    }

    private void reverse(int[] nums, int l, int r){
        while(l<r){
            swap(nums,l,r);
            l++; r--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
