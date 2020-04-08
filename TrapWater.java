// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int trap(int[] height) {
       if(height == null || height.length==0) return 0;
       int[] leftmax = new int[height.length];
        leftmax[0] = 0;
        
        int[] rightmax = new int[height.length];
        
        rightmax[height.length-1]=0;
        //build leftmax
        int runningleft = Integer.MIN_VALUE;
        for(int i =1;i<leftmax.length;i++){
            runningleft = Math.max(runningleft,height[i-1]);
            leftmax[i]=runningleft;
        }
        
        //build rightmax
        int runningright = Integer.MIN_VALUE;
        for(int i = rightmax.length-2;i>=0;i--){
            runningright = Math.max(runningright,height[i+1]);
            rightmax[i] = runningright;
            
        }
        
        
        int current =0; 
        for(int i = 0;i<height.length;i++){
            int tmp = Math.min(leftmax[i],rightmax[i])-height[i];
            if(tmp>0){
                current=current+tmp;
            }
            
        }
        return current;
        
    }
}