//Problem 1
//TC O(n)
//SC O(1)
class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0)
        {
            return 0;
        }
        int lw=0;
        int rw=0;
        int l=0;
        int r=height.length-1;

        int total=0;
        while(l<=r)
        {
            if(lw<=rw)
            {
                if(lw>height[l])
                {
                    total=total+(lw-height[l]);
                }
                else{
                    lw=height[l];
                }
                l++;
            }
            else{
                if(rw>=height[r])
                {
                    total=total+(rw-height[r]);

                }
                else{
                    rw=height[r];
                }
                r--;
            }
        }
        return total;
    }
}

//Problem 2
//TC O(n)
//SC O(n)

class Solution {
    public int hIndex(int[] citations) {
        if(citations==null ||citations.length==0)
        {
            return 0;
        }
        int n=citations.length;
        int result[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
            int index=citations[i];
            if(index>n)
            {
                result[n]++;
            }
            else{
                result[index]++;
            }
        }
        int sum=0;
        for(int i=n;i>=0;i--)
        {
            sum=sum+result[i];
            if(sum>=i)
            {
                return i;
            }
        }
return 0;

    }
}

//Problem 3
//TC O(n)
//SC O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        //k can be more than the size of the array so do this
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
        
    }
    
    public void reverse(int nums[] ,int start ,int end)
    {
        while(start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}