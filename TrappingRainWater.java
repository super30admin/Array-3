package Array-3;

public class TrappingRainWater {
    class Solution {
        public int trap(int[] height) {
            
            int n = height.length;
            if(height == null || n<2)
            {
                return 0;
            }
            
            int leftMax = 0;
            int rightMax = 0;
            int l = 0;
            int r = n-1;
            int water = 0;
            
            while(l<=r)
            {
                
                if(leftMax<=rightMax)
                {
                    
                    if(height[l]<leftMax)
                    {
                        water+= leftMax-height[l];
                    }else{
                        leftMax = height[l];
                    }
                    l++;
                }else{
                    
                    if(height[r]<rightMax)
                    {
                        water+=rightMax-height[r];
                    }else{
                        rightMax = height[r];
                    }
                  r--;
                }
            }
            
            return water;
        }
    }    
}
