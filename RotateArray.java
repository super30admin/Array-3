//TC : O(N)
//SC : O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0||nums==null||nums.length==0) return;
        int n = nums.length;
        if(k>n)
            k = k%n;
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
    }

    private void reverse(int[]nums,int l,int r)
    {
        while(r>=l)
        {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            r--;
            l++;
        }
    }
}