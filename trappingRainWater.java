/*
TC --> O(n)
SC --> O(n)
*/
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for(int i=1;i<n;i++){

            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }//for
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }
        int stored = 0;
        for(int i=1;i<n-1;i++){
            int val = Math.min(leftMax[i], rightMax[i]);
            if(val>height[i]){
                stored+=val-height[i];
            }
        }
        return stored;
    }//method
}//class