//Time Complexity: O(N)
//Space Complexity: O(1)

//Making trappings with left wall and right wall using 4 pointers. 
class Solution {
    public int trap(int[] height){
        
        if(height == null || height.length < 2) return 0;
        
        int result = 0;
        int n = height.length;
        
        int lW = 0; 
        int rW = 0;
        int l = 0;
        int r = n-1;
        
        while(l <= r){
            if(lW <= rW){
                if(height[l] < lW){
                    result += (lW-height[l]);
                }else{
                    lW = height[l];
                }
                l++;
            }else{
                if(height[r] < rW){
                    result += (rW-height[r]);
                }else{
                    rW = height[r];
                }
                r--;
            }
        }
        
        return result;
    }
}