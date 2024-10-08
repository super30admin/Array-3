// Find the max element and find the amount of water that can be trapped to its left and to its right
// TC: O(2n)
// SC : O(1)
class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        int result = 0;
        for(int i=0;i<n;i++) {
            if(height[i] > max) {
                max = height[i];
                maxIdx = i;
            }
        }

        int l = 0;
        int lw = 0;
        while(l<maxIdx) {
            if(height[l] < height[lw]) {
                // I can trap water
                result += (height[lw] - height[l]);
            } else {
                lw = l;
            }
            l++;
        }

        int r = n-1;
        int rw = n-1;
        while(r > maxIdx) {
            if(height[rw] > height[r]) {
                // I can trap water
                result+= (height[rw] - height[r]);
            } else {
                rw = r;
            }
            r--;
        }

        return result;

    }
}


// One-pass solution 
// TC: O(n)
// SC: O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int lw = 0;
        int r = n-1;
        int rw = n-1;
        int result = 0;
        while (l<=r) {
            // Process left side
            if(height[lw] <= height[rw]) {
                if(height[l] < height[lw]) {
                    // I can trap water
                    result += (height[lw] - height[l]);
                } else {
                    lw = l;
                }
                l++;
            } else {
                if(height[rw] > height[r]) {
                    // I can trap water
                    result += (height[rw] - height[r]);
                } else {
                    rw = r;
                }
                r--;
            }
        }
        return result;
    }
}