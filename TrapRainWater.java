// Time: O(n) -> o(3n)
// Space: O(2n)

class SoluTrapRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int collect = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0]=height[0];
        for (int i=1; i<n; i++){
            left[i] = Math.max(height[i], height[i-1]);
        }

        right[n-1]=height[n-1];
        for (int i=n-2; i>=0; i--){
            right[i] = Math.max(height[i], height[i+1]);
        }

        for (int i=0; i<n; i++){
            collect += Math.min(left[i],right[i])-height[i];
        }
        return collect;

    }
}