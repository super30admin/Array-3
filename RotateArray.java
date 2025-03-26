//The idea here is to rotate to the right in-place by first reversing the array from n-k to n-1, then reversing from 0 to n-k-1 and finally reversing the entire array
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length<2) return;
        int n = nums.length;
        k = k%n;
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, 0, n-1);
    }

    private void reverse(int[] nums, int l, int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

}