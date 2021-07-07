//TC - O(n)
//SC - O(n)

class Solution {
    public void rotate(int[] nums, int k) {        
        int[] a = new int[nums.length];
        
        for(int i=0; i< nums.length; ++i)
        {
            a[(i+k)%nums.length] = nums[i];
        }
        
        System.arraycopy(a, 0, nums, 0, nums.length);
    }
}
