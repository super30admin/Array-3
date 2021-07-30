package Array3;

public class TrappingRainWater {
	class Solution {
	    //TC : o(n);
	    //SC : o(1);
	    public int trap(int[] height) {
	        if(height == null || height.length < 2) return 0;
	        
	        int l = 0;
	        int r = height.length-1;
	        int lw = 0;
	        int rw = 0;
	        int result = 0;
	        
	        while(l<=r){
	            if(lw <= rw){
	                //process left wall
	                if(height[l] < lw){
	                    result+= lw - height[l];
	                }else{
	                   lw = height[l]; 
	                }
	                l++;
	            }else{
	                //process right wall
	                if(height[r] < rw){
	                    result+= rw - height[r];
	                }else{
	                   rw = height[r]; 
	                }
	                r--;                
	            }
	        }
	        return result;
	    }
	}
}
