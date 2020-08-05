// Time Complexity : O(n)  n-length of the array
// Space Complexity : O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length<2)return;
        int n=nums.length;
        if(k>n) k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        
    }
    
    public void swap(int i,int j,int nums[])
    {
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    public void reverse(int nums[],int l,int r)
    {
        while(l<r)
        {
            swap(l,r,nums);
            l++;
            r--;
        }
    }
    
}

//Brute force
// Time Complexity : O(nk) k-steps  n-length of the array
// Space Complexity : O(1)
//TLE

class Solution {
    public void rotate(int[] nums, int k) {
        int last=0,temp=0;
        while(k>0)
        {
            last=nums[nums.length-1];
            for(int i=0;i<nums.length;i++)
            {
                temp=nums[i];
                nums[i]=last;
                last=temp;
            }
            k--;
            
        }
        
    }
}
