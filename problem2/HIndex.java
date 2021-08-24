// Time Complexity : O(n), n -> Number of elevations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.Arrays;

public class HIndex {
	/********************* Brute Force *********************/
	// Time Complexity : O(nlog n), n -> Number of elevations
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int hIndexBruteForce(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}

		Arrays.sort(citations);

		int n = citations.length;
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (citations[mid] == n - mid) {
				return citations[mid];
			} else if (citations[mid] < n - mid) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return n - low;
	}

	/********************* Bucket Sort *********************/
	// Time Complexity : O(n), n -> Number of elevations
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}

		int n = citations.length;
		int[] buckets = new int[n + 1];

		for (int i = 0; i < n; i++) {
			if (citations[i] >= n) {
				buckets[n]++;
			} else {
				buckets[citations[i]]++;
			}
		}

		int papers = 0;
		for (int i = n; i >= 0; i--) {
			papers += buckets[i];

			if (papers >= i) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		HIndex obj = new HIndex();
		int[] citations = { 3, 1, 5, 2, 3 };

		System.out.println("H-Index: " + obj.hIndexBruteForce(citations));
	}

}
