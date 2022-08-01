// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class TrappingRainWater {
    int trapAmount = 0;
    public int trap(int[] height) {
        
        if(height.length<2)
            return 0;
        
        int maxIndex = 0;
        for(int i=0;i<height.length;i++) {
            if(height[i]>height[maxIndex])
                maxIndex = i;
        }
        
        getTrapAmountLeft(height, 0, maxIndex);
        getTrapAmountRight(height, height.length-1, maxIndex);
        
        return trapAmount;
    }
    
    private void getTrapAmountLeft(int[] height, int start, int end) {
        
        int max = 0;
        for(int i = start;i<end;i++) {
            if(height[i] < max) {
                trapAmount+=max-height[i];
            }else{
                max = height[i];
            }
        }
    }
                                   
    private void getTrapAmountRight(int[] height, int start, int end) {
        int max = 0;
        for(int i = start;i>end;i--) {
            if(height[i] < max) {
                trapAmount+=max-height[i];
            }else{
                max = height[i];
            }
        }
    }                               
}
