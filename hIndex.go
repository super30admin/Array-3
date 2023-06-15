// TC - O(n)
// SC - O(n) - for the buckets array

// Approach:
// We use a bucket-sort type of approach where we sort each value in a "bucket"
// with the help of a separate buckets array where each index is the number of
// citations and the value is the number of papers with at least those number
// of citations. Then we use a running sum in reverse to find which value
// matches our criteria for h-index.

package main

func hIndex(citations []int) int {
	if len(citations) == 0 {
		return 0
	}

	n := len(citations)
	buckets := make([]int, n+1)

	for i := 0; i < n; i++ {
		index := citations[i]
		if citations[i] >= n {
			buckets[n]++
		} else {
			buckets[index]++
		}
	}

	rSum := 0
	for i := n; i >= 0; i-- {
		rSum += buckets[i]
		if rSum >= i {
			return i
		}
	}

	return 0
}
