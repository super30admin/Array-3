public class TrappingRainWater {
    //dp solution
    //time complexity:O(N)
    //space complexity: O(N)-> we are maintaining 2 dp arrays
     public int trapDP(int[] height) {

         int[] leftMax = new int[height.length];
         int[] rightMax = new int[height.length];
         leftMax[0] = 0;
         rightMax[height.length - 1] = 0;

         for(int i = 1; i< height.length; i++){
             leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
         }

         for(int i = height.length - 2; i >=0 ; i--){
             rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
         }

         int amt = 0;
         for(int i = 1; i <= height.length - 2; i++){
             int remainingHeight = (Math.min(leftMax[i], rightMax[i])- height[i]);
             amt+= remainingHeight < 0? 0: remainingHeight;
         }

         return amt;

     }

    //time complexity: O(N)
    //space complexoty: O(1)
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int amount = 0;
        int right = height.length - 1;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax) leftMax = height[left];
                else amount+= leftMax - height[left];

                left++;
            }
            else{
                if(height[right] >= rightMax) rightMax = height[right];
                else amount+= rightMax - height[right];

                right--;

            }
        }

        return amount;

    }
}
