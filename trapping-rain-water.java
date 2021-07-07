// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int trap(int[] height) {
        //base case
        if(height == null || height.length == 0)
            return 0;
        
        int n=height.length;
        int leftMax[]=new int[n], rightMax[]=new int[n];
        
        leftMax[0]=0;
        for(int i=1;i<n;i++)
            leftMax[i]=Math.max(leftMax[i-1], height[i-1]);
        
        rightMax[n-1]=0;
        for(int i=n-2;i>=0;i--)
            rightMax[i]=Math.max(rightMax[i+1], height[i+1]);
        
        int total=0;
        for(int i=0;i<n;i++)
        {
            int currWater=Math.min(leftMax[i], rightMax[i])-height[i];
            if(currWater < 0)
                currWater=0;
            
            total+=currWater;
        }
        return total;
    }
}
