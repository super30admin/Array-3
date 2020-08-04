//Time complexity=O(N)
//Space complexity=O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//We are having 4 pointer, that point to height and index of the array. 
//Initially l is at start and r is n-1 index, lw and rw are height of left index and right index.
//So, if rw is greater than lw, than we are checking for the left pointer and left wall and which is greater if lw is greater than height at left index height than we are adding it to the amount where we are taking the difference of left wall the height at left index. Similarly for right wall and right index. We stop when both the l and r cross each other.
class Solution {
    public int trap(int[] height) {
        if(height==null  || height.length<2)
            return 0;
        int n=height.length,amount=0;
        int l=0,r=n-1; //they point to the index not height
        int lw=0,rw=0;//They are heights at any point not index
        while(l<=r)
        {
            if(lw<=rw){
            if(lw<height[l])
            {
                lw=height[l];
                
            }
            else
            {
                amount+=lw-height[l];
            }
            l++;
            }else{
            if(rw<height[r])
            {
                rw=height[r];
                
            }
            else
            {
                amount+=rw-height[r];
            }
            r--;
            }
            
            
        }
        return amount;
    }
}