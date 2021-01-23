// Time Complexity :O(N) 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: Maintain four pointers two for left and two for right. We start traversing 
// from left if the height at left is less otherwise right. We will update the sum as we proceed traversing until we reach height of left
// is greater than or equals the height of the current block. Similiraly for the right pointer as well until the left < right.
class Solution {
    public int trap(int[] height) {
        if(height==null ||height.length==0)
            return 0;
        int left=0;        
        int right=height.length-1;
        int sum=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]==0){
                    left++;
                    continue;
                }
                int l=left+1;
                while(height[l]<height[left]){
                    sum+=height[left]-height[l];
                    l++;
                }
                left=l;
            }
            else{
                if(height[right]==0){
                    right--;
                    continue;
                }
                int r=right-1;
                while(height[r]<height[right]){
                    sum+=height[right]-height[r];
                    r--;
                }
                right=r;
            }
        }
        return sum;
    }
}