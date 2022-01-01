class Solution {
    public int trap(int[] height) {
        int leftMaxSoFar[] = new int[height.length];
        int rightMaxSoFar[] = new int[height.length];
        leftMaxSoFar[0] = height[0];
        rightMaxSoFar[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            leftMaxSoFar[i] = Math.max(leftMaxSoFar[i-1], height[i]);
            rightMaxSoFar[height.length-1-i] = Math.max(rightMaxSoFar[height.length-i], height[height.length-1-i]);
        }

        int sum = 0;
        for(int i=1;i<height.length-1;i++)
            sum += Math.max(Math.min(leftMaxSoFar[i-1], rightMaxSoFar[i+1]) - height[i],0);

        return sum;

    }
}