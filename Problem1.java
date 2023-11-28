//Time Complexity : O(n)
//Space Complexity: O(1)

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int max = 0; int maxIdx = 0;
        for(int i=0;i<n;i++){
            if(max < height[i]){
                max = height[i];
                maxIdx = i;
            }
        }
        int lw = 0;
        int lp = 0;
        while(lp < maxIdx){
            if(lw <= height[lp]){
                lw = height[lp];
            } else {
                result += (lw - height[lp]);
            }
            lp++;
        }
        int rw = 0;
        int rp = n-1;
        while(rp > maxIdx){
            if(rw <= height[rp]){
                rw = height[rp];
            } else {
                result += (rw - height[rp]);
            }
            rp--;
        }
        return result;
    }
}
