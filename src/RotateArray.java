// Time Complexity:  O(n)
// Space Complexity: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0) return;
        k = k%nums.length;
        int n = nums.length;                       // [1,2,3,4,5,6,7], k=3
        reverse(nums, 0, n-k-1);                   // [4,3,2,1,5,6,7]
        reverse(nums, n-k, n-1);                   // [4,3,2,1,7,6,5]
        reverse(nums, 0, n-1);                     // [5,6,7,1,2,3,4]
    }
    private void reverse(int[] nums, int l, int r) {
        while(l<r) {
            nums[l] = (nums[l]+nums[r]) - (nums[r]=nums[l]);
            l++;
            r--;
        }
    }
}
