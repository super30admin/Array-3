/**
1. Adjust rotation steps to handle cases where k >= n.
2. Reverse the entire array.
3. Reverse subarrays from 0 to k-1 and from k to n-1 to rotate the array.
tc-O(n), sc-O(1)
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k>=n) k = k%n;
        rev(nums,0,n-1);
        rev(nums,0,k-1);
        rev(nums, k, n-1);
        
    }
    private void rev(int[] nums, int l, int r){
        while(l<=r){
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
