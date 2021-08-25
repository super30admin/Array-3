class Solution {
    public int trap(int[] height) {
        int total = 0;
        int L = 0;
        int R = height.length - 1;
        int LW = 0;
        int RW = 0;
        
        while(L <= R){
            if(LW < RW){
                if(LW < height[L]){
                    LW = height[L];
                } else{
                    total += LW - height[L];
                }
                L += 1;
            } else{
                if(RW < height[R]){
                    RW = height[R];
                } else{
                    total += RW - height[R];
                }
                R -= 1;
            }
        }
        return total;
    }
}