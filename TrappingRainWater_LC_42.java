/*
TC-O(N)
SC- O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/

public class TrappingRainWater_LC_42 {
    public int trap(int[] height) {
        int trappedWater =0;
        int water[] = new int[height.length];
        int maxL[] = new int[height.length];
        int maxR[] = new int[height.length];

        //[0,1,0,2,1,0,1,3,2,1,2,1]

        //building nearest max to left array
        maxL[0] = height[0];
        for(int i = 1; i< maxL.length; i++){
            maxL[i] = Math.max(maxL[i-1],height[i]);
        }

        //building nearest max to right array
        maxR[maxR.length-1] = height[height.length-1];
        for(int i =  maxR.length-2; i>=0; i--){
            maxR[i] = Math.max(maxR[i+1],height[i]);
        }

        //Building Water array
        for(int i = 0;i<water.length; i++){
            trappedWater+= Math.min(maxL[i], maxR[i]) - height[i];
        }

        // //Summing up water array elements as it is our trapped water - this snippet is not needed because we took care trapped water in Building array itself
        //  for(int i =0; i< water.length; i++){
        //      trappedWater+=water[i];
        //  }
        return trappedWater;
    }
}
