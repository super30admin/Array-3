//TC : O(n) // Single pass on heights array
//SC : O(1)


class Solution {
    public int trap(int[] height) {
        
        if(height == null || height.length == 0)    return 0;
                    
        int result = 0; // No. of Units of trapped water
        int l = 0; // Pointer from left
        int r = height.length - 1; //Pointer from right
    
        int lw = 0;  // Height of left wall
        int rw = 0; // Height of right wall
 
        while(l <= r){
            if(lw <= rw){ // If height of left wall is lesser or equals to height of right wall
                if(height[l] < lw){
                    result += (lw - height[l]) * 1;
                }else{
                    lw = height[l];
                }
                l++;
            } else{
                if(height[r] < rw){
                    result += (rw - height[r]) * 1;
                } else{
                    rw = height[r];
                }
                r--;
            }
        }
           
        return result;    
    }
}
