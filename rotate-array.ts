// Time complexity - O(n), n is the number of elements in nums array
// Space complexity - O(1), no extra space used
function rotate(nums: number[], k: number): void {
	const n = nums.length;

	// handling case if k is larger than n
	k = k % n;

	// reverse the entire array
	reverse(0, n - 1);
	// reverse the first k element
	reverse(0, k - 1);
	// reverse the k...n-1 element
	reverse(k, n - 1);

	function reverse(left: number, right: number) {
		while (left < right) {
			swap(left, right);
			left++;
			right--;
		}
	}

	function swap(i: number, j: number) {
		const temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
