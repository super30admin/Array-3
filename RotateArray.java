// Time complexity - O(n)
// Space complexity - O(1)
// Solved on leetcode - Yes
// faced any issues - No
// Initially reverse the entire list then reverse the 1st k elements and last n-k elements
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return;
        k = k>n ? k%n : k;
        reverse(nums, 0 , n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums, int i, int j) {
        while(i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
