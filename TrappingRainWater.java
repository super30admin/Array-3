// Time Complexity :  O(N)
// Space Complexity : O(N) for extra space for left and right arrays .
// Did this code successfully run on Leetcode : Yes

class TrappingRainWater {
    public int trap(int[] height) {
        
        // check edge case if empty
        if (height.length==0) return 0;
        
        // create two arrays left and right
        int[] leftarea=new int[height.length];
        int[] rightarea=new int[height.length];
        
        int maxarea=0;
        
        leftarea[0]=height[0];
        rightarea[height.length-1]=height[height.length-1];
        
        //Compute leftarea which is max on left side and itself
        for(int l=1;l<height.length-1;l++)
            leftarea[l]=Math.max(leftarea[l-1],height[l]);
        
        //Compute rigth area which is max on right and itself
        for(int i=height.length-2;i>=0;i--)
            rightarea[i]=Math.max(height[i],rightarea[i+1]);
        
        //Add volume which is min between left and right and remove actual height
        
        for(int i=0;i<height.length-1;i++)
        maxarea=maxarea+Math.min(leftarea[i],rightarea[i])-height[i];
        
        return maxarea;
    }
}