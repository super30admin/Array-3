//Tc O(N)
//sc O(N)
class Solution {
    public void rotate(int[] nums, int k) 
    {
        int n=nums.length;
        int num[] = new int[n];
        int x=0;
        for(int i=0;i<n;i++)
        {
            num[(i+k)%n]=nums[i];
        }
        for(int i=0;i<n;i++)
        {
            nums[i]=num[i];
        }
    }
}