class Solution {
    //TC: O(n)
    //SC: O(1)
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int lw = 0; int rw = 0;
        int  l = 0, r = n - 1;
        while(l <= r){
            if(lw >= rw){
                //right
                if(height[r] < rw){
                    result += rw - height[r];
                }else{
                    rw = height[r];
                } 
                r--;           
            }else{
                if(height[l] < lw){
                    result += lw - height[l];
                }else{
                    lw = height[l];
                } 
                l++; 
            }

        }
        return result;
    }
}
