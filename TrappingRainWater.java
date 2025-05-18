class TrappingRainWater {
    public int trap(int[] height) {
        int max = 0;
        int maxIdx = 0;

        for(int i=0; i<height.length; i++){
            if(height[i] > max){
                max = height[i];
                maxIdx = i;
            }
        }

        int l = 0;
        int lw = 0;
        int res = 0;

        while(l < maxIdx){
            if(height[l] < height[lw]){
                res += height[lw] - height[l];
            }
            else{
                lw = l;
            }
            l++;
        }

        int rw = height.length-1;
        int r = height.length-1;

        while(r > maxIdx){
            if(height[r] < height[rw]){
                res += height[rw] - height[r];
            }
            else{
                rw = r;
            }
            r--;
        }
        return res;
    }
}