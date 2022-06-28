//o(n) time and o(1) space
public int trap(int[] height) {
	int n = height.length;
	if(n <= 2) return 0;
	int sum = 0;

	int l = 0, r = n - 1;
	int leftMax = 0, rightMax = 0;
	while(l < r) {
		if(height[l] <= height[r]) {
			if(height[l] >= leftMax) leftMax = height[l];
			else {
				sum += leftMax - height[l];
			}
			l++;
		} else {
			if(height[r] >= rightMax) rightMax = height[r];
			else {
				sum += rightMax - height[r];
			}
			r--;
		}
	}

	return sum;
}
