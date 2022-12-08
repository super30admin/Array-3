public class Problem1 {
    public static int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int rain = 0;
        int len = height.length;
        int[] lMax = new int[len];
        int[] rMax = new int[len];
        lMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);

        }
        rMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }

        for (int i = 0; i < rMax.length - 1; i++) {
            rain += Math.min(rMax[i], lMax[i]) - height[i];
        }
        return rain;
    }

    public static void main(String[] args) {
        int[] heights = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.print(trap(heights));
    }
}
