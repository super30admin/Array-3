//Time Complexity : O(2n) ~ O(n)
//Space Complexity : O(1)
class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int max = 0;
        int maxIdx = -1;
        for(int i = 0; i < n; i++) {
            if(height[i]>max) {
                max = height[i];
                maxIdx = i;
            }
        }
        int result = 0;
        int l = 0, lw = 0;
        while(l < maxIdx) {
            if(lw > height[l]) {
                result += lw - height[l];
            } else {
                lw = height[l];
            }
            l++;
        }
        int r = n-1, rw = 0;
        while(r > maxIdx) {
            if(rw > height[r]) {
                result += rw - height[r];
            } else {
                rw = height[r];
            }
            r--;
        }
        return result;
    }
}