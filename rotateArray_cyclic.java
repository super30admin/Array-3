// Time O(n * (n-k)) please correct if I am wrong
// Space O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0 || k==nums.length || nums==null || nums.length==0 || nums.length==1)
            return;
        
        
        k=k%nums.length;
        int n=nums.length;
        int count=0;
        
        for(int i=0;count<n;i++)
        {
            int index=i;
            int curr=nums[i];

            do
            {
                int currIndex=(index+k)%nums.length;
                int temp=nums[currIndex];
            
                nums[currIndex]=curr;
            
                curr=temp;
                index=currIndex;
            
                count++;
            } while(i!=index);
        }
    }
}