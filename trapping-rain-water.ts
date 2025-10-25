function trap(height: number[]): number {
	const n = height.length;
	let r = n - 1;
	let l = 0;
	let lw = 0;
	let rw = 0;
	let result = 0;

	while (l <= r) {
		if (rw > lw) {
			// rw acting as a dam, so we can trap water on the left side
			if (height[l] > lw) {
				lw = height[l];
			} else {
				result += 1 * lw - height[l];
			}
			l++;
		} else {
			// lw acting as a dam, so we can trap water on the right side
			if (height[r] > rw) {
				rw = height[r];
			} else {
				result += 1 * rw - height[r];
			}
			r--;
		}
	}
	return result;
}
