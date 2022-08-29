// 0(n) time
// 0(1) space
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length ==0 || nums==null)
        {
            return;
        }
        int n = nums.length;
        k = k % n;
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);

    }



    private void reverse(int[] nums, int left, int right)
    {
        while(left<right)
        {
            int temp=nums[left];
            nums[left]= nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}

