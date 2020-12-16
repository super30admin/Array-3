public class TrapRain {

	// time complexity : O(n)
	public int trap(int[] height) {

		if (height == null || height.length == 0)
			return 0;

		int n = height.length - 1;
		int lw = 0;
		int rw = 0;
		int l = 0;
		int r = n;
		int result = 0;

		while (l <= r) {

			if (lw <= rw) {
				// left side started processing
				if (height[l] < lw) {

					// only trap when wall is higher than height of left pointer
					result += lw - height[l];

				} else {
					// move to that
					lw = height[l];

				}

				l++;
			} else {
				// right side started processing

				if (height[r] < rw) {
					result += rw - height[r];

				} else {
					rw = height[r];

				}

				r--;
			}

		}

		return result;

	}

	public static void main(String[] args) {
		TrapRain rain = new TrapRain();

		rain.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
	}
}
