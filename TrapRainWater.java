//Time -O(n)
//Space - O(1)
class Solution {
    public int trap(int[] height) {
        int cap =0;
        int l =0;
        int lw = 0;
        int r = height.length-1;
        int rw = 0;
        while(l<=r){
            if(lw<=rw){
                //processleft
                if(lw<height[l]){
                    lw = height[l];
                }else{
                    cap+= lw-height[l];
                }
                l++;
            }else{
                if(rw < height[r]){
                    rw =height[r];
                }else{
                    cap+=rw -height[r];
                }
                r--;
            }
        }
        return cap;
   
    }
}