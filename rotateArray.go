// TC - O(n)
// SC - O(1)

// Approach:
// we use an approach where we reverse either the whole or a part of the given
// array to obtain our desired state.
// 1. First we reverse the entire array
// 2. Then we reverse the array from 0 to k-1
// 3. Then we reverse the array from k to n-1

package main

func rotate(nums []int, k int) {
	if len(nums) == 0 || k == 0 {
		return
	}
	n := len(nums)
	k = k % n // remove extra full-length rotations
	reverse(nums, 0, n-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, n-1)
}

func reverse(nums []int, l, r int) {
	for l <= r { // 2 pointer approach to reverse an array
		nums[l], nums[r] = nums[r], nums[l]
		// temp := nums[l]
		// nums[l] = nums[r]
		// nums[r] = temp
		l++
		r--
	}
}
