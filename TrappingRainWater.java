//TC : O(n)
//SC: O(1)

public class TrappingRainWater {
    public int trap(int[] height) {
      int result = 0;
      int maxHeight = 0;
      int maxInd =-1;
      for(int i=0; i < height.length; i ++){

        if(height[i] >maxHeight){
          maxHeight= height[i];
          maxInd = i;
        }

      }

      int l=0;
      int r= height.length - 1;

      for(int i =0; i < maxInd; i++){

        if( height[i] >height[l]){
          l=i;
        }

        if(height[i] < height[l]){
          result = result + ( height[l] - height[i] );
        }
      }

      for(int i =height.length - 1; i > maxInd; i--){

        if( height[i] >height[r]){
          r=i;
        }

        if(height[i] < height[r]){
          result = result + ( height[r] - height[i] );
        }
      }

      return result;
    }
  }
