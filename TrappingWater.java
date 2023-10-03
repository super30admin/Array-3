//TC -- 
//SC -- 
//Here we are using 4 pointer, two as indexes and other 2 as left and right wall.

class Solution{
    public int trap(int[] height) {
        int area = 0;
        int n = height.length;
        int l = 0; //indexes
        int r = n-1; 
        int lw = 0; //Heights
        int rw = 0;
        while(l <= r){
            if(lw<rw){
                //right wass is acting as dam -> process left side.
                if(height[l]<lw){
                    area = area + (lw-height[l]);
                }else{
                    lw = height[l];
                }
                l++;
            }else{
                if(height[r] < rw){
                    area = area + (rw - height[r]);
                }else {
                    rw = height[r];
                }
                r--;
            }
        }
        return area;
    }
}