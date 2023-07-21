public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                }
                ans += leftMax - height[left];
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Example input array
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        int trappedWater = solution.trap(height);
        System.out.println("Trapped rainwater: " + trappedWater);
    }
}