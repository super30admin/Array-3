// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public void rotate(int[] nums, int k) {
        //edge case
        if(nums==null || nums.length < 2) // there should be atleast 2 numbers to rotate the array
            return;
        int n = nums.length;
        if(k>n) // if k is greater than n
            k = k%n; // reset k according to mod value taken with n
        reverse(nums,0,n-1); //reversing all elements
        reverse(nums,0,k-1); //reversing first k elements
        reverse(nums,k,n-1); //reversing last n-k elements
    }
    private void reverse(int[] nums, int i, int j)
    {
        while(i<j) // just putting two pinters and swapping the values at the pointers till they meet
        {
           swap(nums,i,j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    public int trap(int[] height) {
        //edge case
      if(height == null || height.length == 0)
          return 0;
        
        int n = height.length; 
        int l=0; //left pointer
        int r = n-1; //right pointer
        int lw = 0; //  left wall (height not indices)
        int rw = 0;
        int water = 0;
        while(l<=r) // till both pointer does not meet
        {
            if(lw<=rw) //if left wall is smaller than right wall 
            { // process left side
                if(height[l]<lw) // if left wall is higher than height at left index
                {
                    water += (lw - height[l])*1; // we can trap water
                }
                else 
                    lw = height[l]; // make the left wall as the height at left index
                l++; // move the left pointer
            }
            else //if left wall is greater than right wall 
            { // process right side
                if(height[r]<rw) // if right wall is higher than height at right index
                {
                    water += (rw - height[r])*1; // we can trap water
                }
                else
                    rw = height[r]; // make the right wall as the height at right index
                r--; // move the right pointer
            }
        }
        
        return water;
    }
}

// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int hIndex(int[] citations) {
      int n = citations.length;
        Arrays.sort(citations); //sorting the array
        for(int i=0;i<n;i++) // iterating the array
        {
            int diff = n-i; //finding h index i.e the number of citations with minimum value as citation[i] 
            if(citations[i]>=diff) // if the citation incraese h index or become equal
                return diff; // return h index
        }
        
        return 0;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int hIndex(int[] citations) {
      int n = citations.length;
      //bucket sort
      int buckets[] = new int[n+1]; // one more bucket to store values greater than n in citations array
        for(int i=0;i<n;i++) //iterate over citations
        {
          buckets[Math.min(citations[i],n)]++;  // incraese the value bucket index = citations[i] , if citations[i] > n then we incraese at last index of buckets array 
        }
        int sum=0;
        for(int i=buckets.length-1;i>=0;i--) //iterate over the buckets array backwards
        {
            sum+= buckets[i]; // find sum of bucket array (number of papers)
            if(sum>=i) // when the sum crosses the index (citations)
                return i; // return citations
        }
        return 0;
    }
}