//tc: O(n)
//sc: O(1)

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int l = 0, r = height.length - 1;
        int lw = 0, rw = 0, res = 0;
        
        while(l <= r){
            if(lw <= rw){
                //means there is right wall which is greater than left wall
                if(lw < height[l]){
                    //cannot hold water since current height of building is higher than left wall
                    lw = height[l];
                }else{
                    //update the quantity of water
                    res += lw - height[l];
                }
                l++;
            }else{
                //means there is left wall which is greater than right wall
                if(rw < height[r]){
                    //cannot hold water since current height of building is higher than right wall
                    rw = height[r];
                }else{
                    //update the quantity of water
                    res += rw - height[r];
                }
                r--;
            }
        }
        return res;
    }
}