// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int trap(int[] height) {
        
        int lmax = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        
        int l=0, r=height.length-1;
        int ans=0;
        
        while(l<r) {
            
            if(lmax<height[l]) {
                lmax = height[l];
            }
            if(rmax<height[r]) {
                rmax = height[r];
            }
            
            if(lmax<rmax) {
                ans += lmax-height[l];   
                l++;
            }
            else {
                ans += rmax-height[r];
                r--;
            }
        }
        return ans;
    }
}
