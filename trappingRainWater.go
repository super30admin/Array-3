// TC - O(n)
// SC - O(1)

// Approach:
// We use a 2 pointers approach (4 pointers in reality) in order to track all
// the valid "walls" that can trap rain water. Two pointers will track the
// heights and 2 pointers will track the index of those heights which are
// valid. If any heights are invalid, then the "wall" pointers are moved.

package main

func trap(height []int) int {
	if len(height) <= 2 {
		return 0
	}

	n := len(height)

	// initialize the 4 pointers (2 pointers approach)
	// lw and rw track the "walls" between which water can be trapped
	// l and r are pointers that run through between lw and rw and finds
	// new walls if needed
	lw, rw, l, r := height[0], height[n-1], 0, n-1
	total := 0

	for l <= r {
		if lw <= rw { // left wall is smaller
			if height[l] <= lw { // water can be trapped for now
				total += lw - height[l]
			} else { // water cannot be trapped, but next higher wall found
				lw = height[l]
			}
			l++ // move to next height
		} else { // right wall is smaller
			if height[r] <= rw { // water can be trapped for now
				total += rw - height[r]
			} else { // water cannot be trapped, but next higher wall found
				rw = height[r]
			}
			r-- // move to next height
		}
	}

	return total
}
