// Time Complexity: O(n) where n is the length of the height array
// Space Complexity: O(n)


class TrappingRainWater {
    public int trap(int[] height) {
        // find max from left
        // find max from right
        // get their min and substract from current height

        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;
    }

    // 2nd Approach
    public int trap2(int[] height) {
        // 2nd Approach

        // find overall max
        // find trap from left to maxId
        // and right to maxIdx

        int maxIdx = 0;
        int n = height.length;

        for(int i = 0; i < n; i++){
            if (height[i] > height[maxIdx]) {
                maxIdx = i;
            }
        }

        int lw = 0;
        int l = 0;
        int result = 0;

        while(l < maxIdx){
            if(lw > height[l]){
                result += lw - height[l];
            }else{
                lw = height[l];
            }
            l++;
        }

        int rw = 0;
        int r = n-1;

        while(r > maxIdx){
            if(rw > height[r]){
                result += rw - height[r];
            }else{
                rw = height[r];
            }
            r--;
        }
        return result;
    }
}
