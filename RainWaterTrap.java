/**
 * Time Complexity : O(n) where n is the number of elements 
 * Space Complexity : O(1)
 */
public class RainWaterTrap {
    public int trap(int[] height) {
        if(height == null || height.length == 0){return 0;}
        int lw  =0, rw =0, l =0, r = height.length-1, amount  = 0;
        while(l <= r){
            if(lw < rw){                                                          
                if(height[l] < lw){                                             
                    amount += lw - height[l];                                 
                }
                else {
                    lw = height[l];                                                     
                }
                l++;
            } else {
                 if(height[r] < rw){
                    amount += rw - height[r];                                                   
                }
                else {
                    rw = height[r];                                                             
                }
                r--;
            }
        }
        return amount;                                                                              
    } 
}