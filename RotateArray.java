//Time Complexity-O(n)
//Space Complexity-O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null||
           nums.length==0||
          k==0)
        {
            return;
        }
        int length=nums.length;
        k=k%length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);            
    }
    void reverse(int[] nums,int i,int j)
    {
        while(i<j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }

}