// Time Complexity : O(n) for the reverse string operations as max.
// Space Complexity : O(1) we are not creating any space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    int trap(vector<int>& height) {
       if(height.size() == 0){ return 0;}
        
        int L = 0;
        int R = height.size()-1;
        int LW = 0;
        int RW = 0;
        
        int total = 0;
        
        
        while ( L <= R){
            if(LW <RW){
                if(LW < height[L]){
                    LW = height[L];
                }else{
                    total += LW - height[L];
                }
                L +=1;
                
            }else{
                
                if(RW < height[R]){
                    RW = height[R];
                    
                }else{
                    total += RW - height[R];
                }
                R -=1;
                
            }
            
            
            
        }
        return total;
        
    }
};