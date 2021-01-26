class Solution {
    public int trap(int[] height) {
        
        if(height == null || height.length==0){
            return 0;
        }
        int result = 0;
        int n = height.length;
        
        int l = 0;
        int r = n-1;
        int l_max = height[l];
        int r_max = height[r];
        
        while(l <= r){
            
            if(height[l] <= height[r]){
            
                if(height[l] >= l_max){
                l_max = height[l];
            }else{
                result += l_max - height[l];
            }
            l++;
            } else{
                if(height[r] >= r_max){
                    r_max = height[r];
                }else{
                    result += r_max - height[r];
                }
                r--;
            }
            
            
        }
        
        return result;
        
    }
}