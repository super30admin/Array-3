//TimeComplexity: O(n)
//SpaceComplexity: O(n)
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int[] leftMost = new int[height.length];
        int[]  rightMost = new int[height.length];
        
        int n = height.length;
        
        leftMost[0] = 0;
        for(int i =1; i< n;i++)leftMost[i] = Math.max(leftMost[i-1], height[i-1]);
        
        rightMost[n-1] = 0;
        for(int i = n-2; i>= 0; i--)rightMost[i] = Math.max(rightMost[i+1], height[i+1]);
        
        int total = 0;
        
        for(int i = 0; i< n; i++){
            int current = Math.min(leftMost[i], rightMost[i]) - height[i];
            if(current < 0)current = 0;
            
            total+=current;
        }
        return total;
    }
}
