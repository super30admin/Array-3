// Time complexity = O(n)
// Space complexity = O(n)


class Solution {
  public int trap(int[] height) {
    int n = height.length;
    int result = 0;
    int maxL = height[0];
    int maxR = height[n-1];
    if(n == 0) return 0;
    int[] maxLeft = new int[n];
    int[] maxRight = new int[n];
    for(int i = 0; i<n; i++) {
      if(height[i] > maxL) maxL = height[i];
      maxLeft[i] = maxL;
    }
    for(int i = n-1; i>=0; i--) {
      if(height[i] > maxR) maxR = height[i];
      maxRight[i] = maxR;
    }
    for(int i = 0; i<n; i++) {
      result += Math.min(maxLeft[i], maxRight[i]) - height[i];
    }
    return result;
  }
}