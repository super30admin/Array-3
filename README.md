# Array-3

## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)
## Time Complexity:O(n) Space Complexity:O(1)
class Solution {
    public int trap(int[] height) {
       int n=height.length;
       

       int result=0;
       int l=0,lw=0;
       int r=n-1,rw=0;

       while(l<=r)
       {
        if(lw<=rw)
        {
            if(height[l]<lw)
            {
                result+=lw-height[l];
            }
            else{
                lw=height[l];
            }
            l++;
        }
        else
        {
            if(height[r]<rw)
            {
                result+=rw-height[r];
            }
            else{
                rw=height[r];
            }
            r--;
        }
       }
       
       return result;

    }
}

## Problem2 H-Index (https://leetcode.com/problems/h-index/)
## Time:O(N) Space:O(1)

class Solution {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int count = 0; 

        for (int i = n - 1; i >= 0; i--) { 
            if (citations[i] >= count + 1) {
                count++; 
            } else {
                break; 
            }
        }
        return count; 
    }
}


## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)
## Time:O(N) Space:O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);


    }
    private void reverse(int[] nums,int i,int j)
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