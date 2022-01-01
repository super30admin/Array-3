// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int trap(int[] height) {
        int[] leftMax=new int[height.length];
        int[] rightMax=new int[height.length];
        
        for(int i=0;i<height.length;i++){
            if(i==0){ 
                leftMax[i]=height[i];
            }else{
                leftMax[i]=(Math.max(height[i],leftMax[i-1]));
            }
        }
        
         for(int i=height.length-1;i>=0;i--){
            if(i==height.length-1){ 
                rightMax[i]=height[i];
            }else{
                rightMax[i]=(Math.max(height[i],rightMax[i+1]));
            }
        }
        int result=0;
        for(int i=0;i<height.length;i++){
            result+=Math.min(rightMax[i],leftMax[i])-height[i];
        }
        
        return result;
    }
}