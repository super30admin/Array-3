// Time Complexity :O(n) where n is the number of elements in the heights  array
// Space Complexity :O(1) as no auxiliary space is used
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
public class TrapRainWater {
    public int trap(int[] height) {
        if(height == null || height.length < 1){
            return 0;
        }
        int n = height.length;
        int maxIndex =-1;
        int maxHeight = 0;
        for(int i=0; i<n; i++){
            if(height[i] > maxHeight){
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        //left
        int lw = 0;
        int result = 0;
        for(int i =lw; i<maxIndex; i++){
            if(height[i] < lw){
                result = result + (lw-height[i]) * 1;
            }else{
                lw = height[i];
            }
        }
        int rw = 0;
        for(int i = n-1; i>maxIndex; i--){
            if(height[i] < rw){
                result = result + (rw-height[i]) * 1;
            }else{
                rw = height[i];
            }
        }
        return result;
    }

    public int trap2(int[] height) {
        if(height == null || height.length < 1){
            return 0;
        }
        int n = height.length;
        int lw = 0;
        int rw = 0;
        int left = 0;
        int right = n-1;
        int result = 0;

        while(left< n && right >=0 && left<=right){
            if(lw <= rw){
                //process lw with left
                if(height[left] < lw){
                    result = result + lw-height[left];
                }else{
                    lw = height[left];
                }
                left++;
            }else{
                //process rw with right
                if(height[right] < rw){
                    result = result + rw-height[right];
                }else{
                    rw = height[right];
                }
                right--;
            }
        }
        return result;
    }
}
