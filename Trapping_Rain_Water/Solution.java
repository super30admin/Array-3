// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We are keeping a track of right wall and left wall and if they are greater than height we are currently processing
 * If we get greater walls then we can trap some water which will be min(right wall, left wall) - current height
 * if the walls are less we want to go to next indexes where walls will be higher than currently processing height
 * if left wall <= right wall, we will process element from left side else from right side
 * For left side, we will check if left wall is greater than left height, then we calculate water trapped and go to next height, else we increament wall and height
 * For right side, we check if right wall is greaer than right height, then we calculate trapped water and go to previous height, else decrement wall and height
*/


class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)return 0;
        
        //return extraSpace(height);
        
        int ans = 0;      
        int lw = 0;
        int l = 1;
        int rw = height.length - 1;
        int r = height.length - 2;
        
        while(l <= r){
            if(height[lw] <= height[rw]){
                if(height[lw] <= height[l]){
                    lw = l;
                    l++;
                }else{
                    ans = ans + height[lw] - height[l];
                    l++;
                }
            }else{
                if(height[rw] <= height[r]){
                    rw = r;
                    r--;
                }else{
                    ans = ans + height[rw] - height[r];
                    r--;
                }
            }
        }
        
        return ans;
    }
    
    private int extraSpace(int[] height){
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        int max = height[0];
        
        for(int i = 1; i < left.length;i++){
            left[i] = max;
            max = Math.max(max, height[i]);
        }
        
        max = height[height.length - 1];
        
        for(int i = right.length-2; i >= 0;i--){
            right[i] = max;
            max = Math.max(max, height[i]);
        }
        
        int ans = 0;
        
        for(int i = 0; i < height.length;i++){
            int min = Math.min(left[i], right[i]);
            
            if(min - height[i] > 0){
                ans = ans + min - height[i];
            }
        }
        return ans;
    }
}