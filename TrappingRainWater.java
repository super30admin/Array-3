// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



public class TrappingRainWater {
	class Solution {
	    public int trap(int[] height) {
	        int result =0;
	        if(height==null || height.length <2) return result;
	        
	        int leftp=0;
	        int rightp=height.length-1;
	        int leftw=0;
	        int rightw=0;
	        
	        while(leftp<=rightp){
	            if(leftw<=rightw){
	                //process left
	                if(height[leftp]<leftw){
	                    result=result+leftw-height[leftp]*1;
	                }else{
	                    leftw=height[leftp];
	                }
	                leftp++;
	            }else{
	                //process right
	                if(height[rightp]<rightw){
	                    result=result+rightw-height[rightp]*1;
	                }else{
	                    rightw=height[rightp];
	                }
	                rightp--;
	            }
	            
	        }
	        return result;
	    }
	}
}
