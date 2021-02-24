//Time Complexity : o(n)
//Space Complexity: o(1)
//Expln: Reverse the while array and reverse first k and k+1 to n to right rotate
//and first n-k elements and last n-k  to n elements to left rotate
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0) return;
        int n = nums.length;
        if(k >= n)
        {
            k = k%n;
        }
        reverse(nums, 0 , n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    private void reverse(int[] nums, int l, int r)
    {
        while(l < r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
}